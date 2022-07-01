package com.simactivation.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simactivation.DTO.AddressUpdation;
import com.simactivation.DTO.CustomerDTO;
import com.simactivation.DTO.IdVerificationDTO;
import com.simactivation.DTO.SimDTO;
import com.simactivation.DTO.SimRegistrationDto;
import com.simactivation.DTO.VerificationDTo;
import com.simactivation.Exceptions.CustomerAndSimCustomException;
import com.simactivation.entity.Customer;
import com.simactivation.entity.CustomerAddress;
import com.simactivation.entity.CustomerIdentity;
import com.simactivation.entity.SimDetails;
import com.simactivation.entity.SimOffers;
import com.simactivation.repository.CustomerAddressRepository;
import com.simactivation.repository.CustomerIdentityRepository;
import com.simactivation.repository.CustomerRepository;
import com.simactivation.repository.SimDetailsRepository;
import com.simactivation.repository.SimOffersRepository;

@Service
@Transactional
public class CustomerAndSimservice {

	@Autowired
	SimDetailsRepository simDetailsRepo;

	@Autowired
	SimOffersRepository simOffersRepo;

	@Autowired
	CustomerAddressRepository cusAddrepo;

	@Autowired
	CustomerIdentityRepository cusidentityRepo;

	@Autowired
	CustomerRepository customerRepo;

	public SimOffers getSimOffer(SimDTO simdto) throws CustomerAndSimCustomException {
		SimDetails simDetails = simDetailsRepo.findByServiceNumberAndSimNumber(simdto.getServiceNumber(),
				simdto.getSimNumber());
		if (simDetails == null) {
			throw new CustomerAndSimCustomException("enter valid combination of sim details");
		} else if (simDetails.getSimStatus().equals("active")) {
			throw new CustomerAndSimCustomException("SIM already active");
		}
		return simOffersRepo.findBySimId(simDetails.getSimId());

	}

	public void cusVerification(CustomerDTO cusDto) throws CustomerAndSimCustomException {
		Customer customer = customerRepo.findByDobAndMail(LocalDate.parse(cusDto.getDateOfBirth()),
				cusDto.getEmailAddress());
		if (customer == null) {
			throw new CustomerAndSimCustomException("No request placed for you.");
		} else {
			CustomerIdentity customerIdentity = new CustomerIdentity();
			customerIdentity.setFirstName(customer.getFirstName());
			customerIdentity.setLastName(customer.getLastName());
			customerIdentity.setDateOfbirth(customer.getDateOfBirth());
			customerIdentity.setEmailAddress(customer.getEmailAddress());
			customerIdentity.setState(customer.getState());
			customerIdentity.setUniqueIdNumber(customer.getUniqueIdNumber());
			cusidentityRepo.save(customerIdentity);
		}
	}

	public void cusMailVerification(VerificationDTo cusDto) throws CustomerAndSimCustomException {
		CustomerIdentity customer = cusidentityRepo.findByName(cusDto.getFirstName(), cusDto.getLastName());
		if (customer == null) {
			throw new CustomerAndSimCustomException("No customer found for the provided details");
		} else if (!customer.getEmailAddress().equals(cusDto.getEmailAddress())) {
			throw new CustomerAndSimCustomException("Invalid email details!!");
		}

	}

	public void addressUpdate(AddressUpdation cusDto) throws CustomerAndSimCustomException {
		Optional<Customer> customer = customerRepo.findById(cusDto.getUniqueIdNumber());
		Optional<CustomerIdentity> cusIdentity = cusidentityRepo.findById(cusDto.getUniqueIdNumber());
		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress.setAddress(cusDto.getAddress());
		customerAddress.setCity(cusDto.getCity());
		customerAddress.setPincode(cusDto.getPincode());
		customerAddress.setState(cusDto.getState());
		CustomerAddress original = customer.get().getCustomeraddress();

		if (customer == null)
			throw new CustomerAndSimCustomException("no customer found with Id");
		else if (original != null) {

			if (original.toString().equals(customerAddress.toString())) {

				throw new CustomerAndSimCustomException("New and old address were same");
			} else {
				customer.get().setState(cusDto.getState());
				System.out.println(cusDto.getState());
				customer.get().setCustomeraddress(customerAddress);
				cusIdentity.get().setState(cusDto.getState());
			}

		} else {

			customer.get().setState(cusDto.getState());
			customer.get().setCustomeraddress(customerAddress);
			cusIdentity.get().setState(cusDto.getState());

		}

	}

	public void cusPurchase(CustomerDTO cusDto) throws CustomerAndSimCustomException {
		Optional<SimDetails> details = simDetailsRepo.findById(cusDto.getSimId());
		Optional<Customer> duplicate = customerRepo.findById(cusDto.getUniqueIdNumber());
		if (!duplicate.isPresent() && details.isPresent() && details.get().getSimStatus().equals("inactive")) {
			Customer cusObj = new Customer();
			cusObj.setSimid(details.get());
			cusObj.setFirstName(cusDto.getFirstName());
			cusObj.setLastName(cusDto.getLastName());
			cusObj.setDateOfBirth(LocalDate.parse(cusDto.getDateOfBirth()));
			cusObj.setEmailAddress(cusDto.getEmailAddress());
			cusObj.setUniqueIdNumber(cusDto.getUniqueIdNumber());
			cusObj.setIdType(cusDto.getIdType());
			CustomerAddress address = new CustomerAddress();
			address.setPincode(cusDto.getPincode());
			address.setAddress(cusDto.getAddress());
			address.setCity(cusDto.getCity());
			address.setState(cusDto.getState());
			cusObj.setCustomeraddress(address);
			customerRepo.save(cusObj);
		} else if (duplicate.isPresent()) {
			throw new CustomerAndSimCustomException("Customer with Id already existed");
		} else if (!details.isPresent()) {
			throw new CustomerAndSimCustomException("Sim card with Given id doesnt exist");
		} else if (details.get().getSimStatus().equals("active")) {
			throw new CustomerAndSimCustomException("SIM already active");
		}
	}

	public void Idverification(IdVerificationDTO dto) throws CustomerAndSimCustomException {
		Customer customer = customerRepo.findByIdAndFirstAndLastName(dto.getUniqueIdNumber(), dto.getFirstName(),
				dto.getLastName());
		if (customer == null)
			throw new CustomerAndSimCustomException("No matching details found");
		else {
			Optional<SimDetails> simObject = simDetailsRepo.findById(customer.getSimid().getSimId());
			String status = simObject.get().getSimStatus();
			if (status.equals("active"))
				throw new CustomerAndSimCustomException("SIM already in active state");
			else {
				simObject.get().setSimStatus("active");
			}
		}
	}
	
	public List<Customer> getCustomers(){
		return customerRepo.findAll();
	}
	public void simRegistration(SimRegistrationDto sim) throws CustomerAndSimCustomException {
		SimDetails simObj = simDetailsRepo.findByServiceNumberAndSimNumber(sim.getServiceNumber(),sim.getSimNumber());
		if(simObj!=null)
			throw new CustomerAndSimCustomException("sim already existed");
		SimDetails newSim = new SimDetails();
		newSim.setServiceNumber(sim.getServiceNumber());
		newSim.setSimNumber(sim.getSimNumber());
		newSim.setSimStatus(sim.getSimStatus());
		SimOffers newSimOffers = new SimOffers();
		newSimOffers.setOfferName(sim.getOfferName());
		newSimOffers.setCallQty(sim.getCallQty());
		newSimOffers.setCost(sim.getCost());
		newSimOffers.setDataQty(sim.getDataQty());
		newSimOffers.setDuration(sim.getDuration());
	    SimDetails simObject = simDetailsRepo.save(newSim);
		SimOffers offers = simOffersRepo.save(newSimOffers);
		simOffersRepo.updateById(offers.getOfferId(),simObject);

	}

}
