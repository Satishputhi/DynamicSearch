package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.CitizenPlan;
import com.spring.repo.CitizenRepo;
import com.spring.search.Searchentity;

@Service
public class CitizenServicImpl implements CitizenService{
	
	@Autowired
	private CitizenRepo citizenrepo;

	@Override
	public List<String> getPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CitizenPlan> getSearchedrecorde(Searchentity search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveExcel(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savepdf(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
