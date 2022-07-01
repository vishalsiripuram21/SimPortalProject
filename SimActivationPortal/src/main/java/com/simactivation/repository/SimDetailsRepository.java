package com.simactivation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simactivation.entity.SimDetails;
import com.simactivation.entity.SimOffers;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetails, Integer>{

	@Query("select sim from SimDetails sim where serviceNumber=?1 and simNumber=?2")
	public SimDetails findByServiceNumberAndSimNumber(String serviceNumber,String simNumber);
}
