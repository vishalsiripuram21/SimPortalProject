package com.simactivation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simactivation.entity.CustomerAddress;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer>{

	@Query("select cus from CustomerAddress cus where address=?1 and city=?2 and pincode=?3 and state=?4")
	public CustomerAddress findByDetails(String address,String city,String pincode,String state);
}
