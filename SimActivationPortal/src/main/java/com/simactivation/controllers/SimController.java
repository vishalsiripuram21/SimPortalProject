package com.simactivation.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simactivation.DTO.IdVerificationDTO;
import com.simactivation.DTO.SimDTO;
import com.simactivation.DTO.SimRegistrationDto;
import com.simactivation.Exceptions.CustomerAndSimCustomException;
import com.simactivation.entity.SimOffers;
import com.simactivation.service.CustomerAndSimservice;

@RestController
@RequestMapping("/sim")
public class SimController {

	@Autowired
	CustomerAndSimservice service;
	
	@PostMapping("/registeringSim")
	public ResponseEntity<String> simRegistration(@RequestBody @Valid SimRegistrationDto simDto) throws CustomerAndSimCustomException{
		service.simRegistration(simDto);
		return new ResponseEntity<>("sim registration successfull",HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/simStatus")
	public SimOffers simDetails(@RequestBody @Valid SimDTO simdto) throws CustomerAndSimCustomException {
		if(simdto!=null)
			return service.getSimOffer(simdto);
		throw new CustomerAndSimCustomException("please enter details");
	}
	@PostMapping("/IdValidation")
	public ResponseEntity<String> IdValidation(@RequestBody @Valid IdVerificationDTO dto) throws CustomerAndSimCustomException{
		service.Idverification(dto);
		return new ResponseEntity<>("SIM activated successfully", HttpStatus.ACCEPTED);
	}
}
