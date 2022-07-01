package com.simactivation.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import net.bytebuddy.asm.Advice.Local;

@Entity
public class CustomerIdentity {

	private LocalDate dateOfbirth;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;

	@Id
	private String uniqueIdNumber;

	public LocalDate getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(LocalDate dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUniqueIdNumber() {
		return uniqueIdNumber;
	}

	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}

	public CustomerIdentity() {

	}

	public CustomerIdentity(LocalDate dateOfbirth, String firstName, String lastName, String emailAddress, String state,
			String uniqueIdNumber) {
		super();
		this.dateOfbirth = dateOfbirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.state = state;
		this.uniqueIdNumber = uniqueIdNumber;
	}

}
