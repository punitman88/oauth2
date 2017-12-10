package com.fuse.customer;

import org.springframework.data.annotation.Id;

public class Login {

	@Id
	private String id;
	private String firstName;
	private String lastName;

	public Login() {
	}

	public Login(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return String.format("Login[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

}