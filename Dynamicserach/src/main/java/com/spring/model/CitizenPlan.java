package com.spring.model;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Entity

public class CitizenPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Citizen_Id;
	public Integer getCitizen_Id() {
		return Citizen_Id;
	}


	public void setCitizen_Id(Integer citizen_Id) {
		Citizen_Id = citizen_Id;
	}


	private String fullname;
	private String email;
	private Long phno;
	
	private Long SSN;
	private String Gender;
	private String planName;
	public CitizenPlan(String fullname, String email, Long phno, Long sSN, String gender, String planName,
			String planStatus, LocalDate startDate, LocalDate endDate) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phno = phno;
		SSN = sSN;
		Gender = gender;
		this.planName = planName;
		this.planStatus = planStatus;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public String getPlanName() {
		return planName;
	}


	public void setPlanName(String planName) {
		this.planName = planName;
	}


	public String getPlanStatus() {
		return planStatus;
	}


	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	private String planStatus;
	 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startDate;
	 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endDate;
	
	
	public CitizenPlan() {
		
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getPhno() {
		return phno;
	}


	public void setPhno(Long phno) {
		this.phno = phno;
	}


	public Long getSSN() {
		return SSN;
	}


	public void setSSN(Long sSN) {
		SSN = sSN;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	
	

	
}
