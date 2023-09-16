package com.spring.search;

import java.time.LocalDate;

public class Searchentity {
	private String plan_name;
	private String plan_status;
	private String Gender;
	private LocalDate start_date;
	private LocalDate end_date;
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
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
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
	@Override
	public String toString() {
		return "Serachentity [plan_name=" + plan_name + ", plan_status=" + plan_status + ", Gender=" + Gender
				+ ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}
	public Searchentity(String plan_name, String plan_status, String gender, LocalDate start_date, LocalDate end_date) {
		super();
		this.plan_name = plan_name;
		this.plan_status = plan_status;
		Gender = gender;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	

}
