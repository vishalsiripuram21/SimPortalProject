package com.simactivation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SimOffers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer offerId;
	private Integer callQty;
	private Integer cost;
	private Integer dataQty;
	private Integer duration;
	private String offerName;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "simid",unique = true)
	private SimDetails simid;
	
	public Integer getOfferId() {
		return offerId;
	}
	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}
	public Integer getCallQty() {
		return callQty;
	}
	public void setCallQty(Integer callQty) {
		this.callQty = callQty;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getDataQty() {
		return dataQty;
	}
	public void setDataQty(Integer dataQty) {
		this.dataQty = dataQty;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public SimDetails getSimDetails() {
		return simid;
	}
	public void setSimDetails(SimDetails simId) {
		this.simid = simid;
	}
	public SimOffers() {
		
	}
	public SimOffers(Integer offerId, Integer callQty, Integer cost, Integer dataQty, Integer duration,
			String offerName, SimDetails simDetails) {
		super();
		this.offerId = offerId;
		this.callQty = callQty;
		this.cost = cost;
		this.dataQty = dataQty;
		this.duration = duration;
		this.offerName = offerName;
		this.simid = simid;
	}
}
