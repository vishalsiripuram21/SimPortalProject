package com.simactivation.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simactivation.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	@Query("select cus from Customer cus where cus.dateOfBirth=?1 and cus.emailAddress = ?2")
	public Customer findByDobAndMail(LocalDate dateOfBirth,String emailAddress);
	
	@Query("select cus from Customer cus where cus.uniqueIdNumber=?1 and cus.firstName = ?2 and cus.lastName=?3")
	public Customer findByIdAndFirstAndLastName(String uniqueIdNumber,String firstName,String lastName);

}
