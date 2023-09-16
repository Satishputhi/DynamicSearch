package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.spring.model.CitizenPlan;
import com.spring.search.Searchentity;

public interface CitizenService {
	public List<String> getPlan();
	public List<String> getstatus();
	public List<CitizenPlan> getSearchedrecorde(Searchentity search);
	public void saveExcel(HttpServletResponse response);
	public void savepdf(HttpServletResponse response);
	

}
