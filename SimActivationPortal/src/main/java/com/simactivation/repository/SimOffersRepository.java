package com.simactivation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simactivation.entity.SimDetails;
import com.simactivation.entity.SimOffers;

@Repository
public interface SimOffersRepository extends JpaRepository<SimOffers, Integer>{

	@Query("select offers from SimOffers offers where simId=?1")
	public SimOffers findBySimId(Integer simid);
	
	@Modifying
	@Query("update SimOffers set simId=:simId where offerId=:offerId")
	public void updateById(Integer offerId,SimDetails simId);
}
