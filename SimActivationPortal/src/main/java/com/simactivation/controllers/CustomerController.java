package com.simactivation.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simactivation.DTO.AddressUpdation;
import com.simactivation.DTO.CustomerDTO;
import com.simactivation.DTO.IdVerificationDTO;
import com.simactivation.DTO.SimDTO;
import com.simactivation.DTO.SimRegistrationDto;
import com.simactivation.DTO.VerificationDTo;
import com.simactivation.Exceptions.CustomerAndSimCustomException;
import com.simactivation.entity.Customer;
import com.simactivation.entity.SimDetails;
import com.simactivation.entity.SimOffers;
import com.simactivation.service.CustomerAndSimservice;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerAndSimservice service;

	

	@GetMapping("/cusdetails")
	public List<Customer> getCustomer(){
		return service.getCustomers();
	}
	
	@PostMapping("/customerPurchase")
	public ResponseEntity<String> purchase(@RequestBody @Valid CustomerDTO cusDto) throws CustomerAndSimCustomException {
		service.cusPurchase(cusDto);
		return new ResponseEntity<>("purchased successfully", HttpStatus.ACCEPTED);
	}

	@PostMapping("/customerVerification")
	public ResponseEntity<String> verification(@RequestBody @Valid CustomerDTO cusDto) throws CustomerAndSimCustomException {
		service.cusVerification(cusDto);
		return new ResponseEntity<>("customer verified successfully", HttpStatus.ACCEPTED);
	}

	@PostMapping("/customerValidationUsingMail")
	public ResponseEntity<String> mailVerification(@RequestBody @Valid VerificationDTo cusDto) throws CustomerAndSimCustomException {
		service.cusMailVerification(cusDto);
		return new ResponseEntity<>("email verified successfully", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/addressUpdate")
	public ResponseEntity<String> addressUpdate(@RequestBody @Valid AddressUpdation
			cusDto) throws CustomerAndSimCustomException {
		service.addressUpdate(cusDto);
		return new ResponseEntity<>("address updated successfully", HttpStatus.ACCEPTED);
	}
	
	

}
