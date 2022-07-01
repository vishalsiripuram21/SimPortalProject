package com.simactivation.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class SimDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer simId;
	
	@Pattern(regexp = "[0-9]{10}",message = "simnumber must be 10 digit numeric value")
	private String serviceNumber;
	
	@Pattern(regexp = "[0-9]{13}",message = "simnumber must be 13 digit value")
	private String simNumber;
	
	private String simStatus;
	
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
	public SimDetails() {
		
	}
	public SimDetails( String serviceNumber, String simNumber, String simStatus) {
		super();
		this.simId = simId;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
	}
	@Override
	public String toString() {
		return "SimDetails [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + "]";
	}
	
	
	
}
