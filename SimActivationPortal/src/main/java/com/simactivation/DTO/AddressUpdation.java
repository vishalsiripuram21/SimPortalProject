package com.simactivation.DTO;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


public class AddressUpdation {

	@Pattern(regexp = "[0-9]{16}",message = "Id should be 16 digit")
	private String uniqueIdNumber;
	
	@Length(max = 25,message = "Address should be maximum of 25 characters")
	private String address;
	
	@Pattern(regexp = "[a-zA-Z\s]*",message = "City/State should not contain any special characters except space")
	private String city;
	
	@Pattern(regexp = "[0-9]{6}",message = "Pin should be 6 digit number")
	private String pincode;
	
	@Pattern(regexp = "[a-zA-Z\s]*",message = "City/State should not contain any special characters except space")
	private String state;

	public String getUniqueIdNumber() {
		return uniqueIdNumber;
	}

	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}

