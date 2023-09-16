package com.spring.model;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class CitizenPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Citizen_Id;
	private String fullname;
	private String email;
	private Integer phno;
	
	private Integer SSN;
	private String Gender;
	private String plan_name;
	private String plan_status;
	private LocalDate start_date;
	private LocalDate end_date;
	
	
	public CitizenPlan() {
		
	}
	
	

	public CitizenPlan(String fullname, String email, int phno, int ssn, String gender, String plan_name,
			String plan_status, LocalDate start_date, LocalDate end_date) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phno = phno;
		this.SSN = ssn;
		this.Gender = gender;
		this.plan_name = plan_name;
		this.plan_status = plan_status;
		this.start_date = start_date;
		this.end_date = end_date;
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
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public String getPlan_status() {
		return plan_status;
	}
	public void setPlan_status(String plan_status) {
		this.plan_status = plan_status;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public Integer getPhno() {
		return phno;
	}

	public void setPhno(Integer phno) {
		this.phno = phno;
	}

	public Integer getSSN() {
		return SSN;
	}
	public void setSSN(Integer sSN) {
		SSN = sSN;
	}
	

}
