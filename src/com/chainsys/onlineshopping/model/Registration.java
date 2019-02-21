package com.chainsys.onlineshopping.model;

import java.time.LocalDate;

import com.sun.jmx.snmp.Timestamp;

public class Registration {
	private int id;
	private	String username;
	private String email;
	private String password;
	private int phoneNumber;
	private LocalDate dateOfBirth;
	private Timestamp createdDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", username=" + username + ", email="
				+ email + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", dateOfBirth=" + dateOfBirth
				+ ", createDate=" + createdDate + "]";
	}
	
}