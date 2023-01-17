package com.ezen.springplanetrip.vo;

import java.sql.Date;

public class UserVO {
	private int userId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String password;
	private String phone;
	private String email;
	private String address;
	private String birthDate;
	private char gender;
	private String userRole;
	private String currentPassword;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName="
				+ fullName + ", password=" + password + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", birthDate=" + birthDate + ", gender=" + gender + ", userRole=" + userRole + ", currentPassword="
				+ currentPassword + "]";
	}
	
	
}
