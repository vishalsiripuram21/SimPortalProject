package com.simactivation.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class VerificationDTo {
	
	public VerificationDTo() {
		
	}
	@NotNull(message = "email address must not be null")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z0-9.-]{2,3}$",message = "Invalid email")
	private String emailAddress;

	@NotNull(message = "firstname not be null")
	@Length(max = 15,message = "Firstname/Lastname should be maximum of 15 characters")
	private String firstName;

	@NotNull(message = "lastname not be null")
	@Length(max = 15,message = "Firstname/Lastname should be maximum of 15 characters")
	private String lastName;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
