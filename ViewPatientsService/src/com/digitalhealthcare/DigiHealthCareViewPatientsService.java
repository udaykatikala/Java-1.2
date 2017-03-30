package com.digitalhealthcare;

import java.sql.Date;

public class DigiHealthCareViewPatientsService {
	
	public String appId;
	public String userId;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String password;
	public String emailId;
	public String photo;
	public String accountType;
	public String gender;
	public String dob;
	public Date   date;
	

	public DigiHealthCareViewPatientsService(
			 String firstName, String lastName,
			String phoneNumber,  String emailId, 
			String gender, String type, String appId, String userId, String photo, String password, String accountType, String dob, Date date) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.appId=appId;
		this.userId=userId;
		this.password=password;
		this.photo=photo;
		this.accountType=accountType;
		this.dob=dob;
		this.date=date;
		
		this.emailId = emailId;
	
		
		this.gender = gender; 
		
	}



	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}
	

	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getPatientName() {
		return firstName;
	}
	public void setPatientName(String patientName) {
		this.firstName = patientName;
	}
	
	
	public String getAppId() {
		return appId;
	}



	public void setAppId(String appId) {
		this.appId = appId;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public DigiHealthCareViewPatientsService(){
		
	}

}
