package com.simactivation.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SimRegistrationDto {

	private Integer simId;

	@NotNull(message = "serviceNumber dont be null")
	@Pattern(regexp = "[0-9]{10}", message = "Invalid details, please check again SIM number/Service number!")
	private String serviceNumber;

	@NotNull(message = "simNumber dont be null")
	@Pattern(regexp = "[0-9]{13}", message = "Invalid details, please check again SIM number/Service number!")
	private String simNumber;

	@NotNull(message = "simstatus dont be null")
	@Pattern(regexp = "active|inactive", message = "simStatus should be active|inactive")
	private String simStatus;

	private Integer offerId;

	@NotNull(message = "callQty dont be null")
	private Integer callQty;

	@NotNull(message = "cost dont be null")
	private Integer cost;

	@NotNull(message = "dataQty dont be null")
	private Integer dataQty;

	@NotNull(message = "duration dont be null")
	private Integer duration;

	@NotNull(message = "offerName dont be null")
	private String offerName;

	public Integer getSimId() {
		return simId;
	}

	public void setSimId(Integer simId) {
		this.simId = simId;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getSimStatus() {
		return simStatus;
	}

	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}

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

}
