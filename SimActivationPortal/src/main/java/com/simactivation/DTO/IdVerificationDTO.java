package com.simactivation.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class IdVerificationDTO {

	@NotNull(message = "adhaar number should not be null")
	@Pattern(regexp = "[0-9]{16}",message = "Id should be 16 digit")
	private String uniqueIdNumber;

	@NotNull(message = "firstname not be null")
	@Length(max = 15,message = "Firstname/Lastname should be maximum of 15 characters")
	private String firstName;

	@NotNull(message = "lastname not be null")
	@Length(max = 15,message = "Firstname/Lastname should be maximum of 15 characters")
	private String lastName;


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

	public String getUniqueIdNumber() {
		return uniqueIdNumber;
	}

	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}
	
}
