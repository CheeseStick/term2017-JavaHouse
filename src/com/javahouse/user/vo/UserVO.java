package com.javahouse.user.vo;

import java.util.Date;

public class UserVO {
	private int userID;
	
	private String firstName;
	private String lastName;
	
	private Date birthday;
	private String phoneNo;
	private String email;
	private String ssn;

	private String address;
	private String addressDetail;
	
	private String password;
	
	private int profilePhotoFileID;

	public int getUserID() {
		return userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getEmail() {
		return email;
	}
	
	public String getSsn() {
		return ssn;
	}

	public String getAddress() {
		return address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public String getPassword() {
		return password;
	}

	public int getProfilePhotoFileID() {
		return profilePhotoFileID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProfilePhotoFileID(int profilePhotoFileID) {
		this.profilePhotoFileID = profilePhotoFileID;
	}
}
