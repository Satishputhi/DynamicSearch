package com.spring.search;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Searchentity {
	private String Gender;
	private String planName;
	
	private String planStatus;
	 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startDate;
	 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endDate;
	
	public Searchentity() {
		
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
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
	
	@Override
	public String toString() {
		return "Searchentity [Gender=" + Gender + ", planName=" + planName + ", planStatus=" + planStatus
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public Searchentity(String gender, String planName, String planStatus, LocalDate startDate, LocalDate endDate) {
		super();
		Gender = gender;
		this.planName = planName;
		this.planStatus = planStatus;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	

}
