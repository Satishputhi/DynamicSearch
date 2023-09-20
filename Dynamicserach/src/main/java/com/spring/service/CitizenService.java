package com.spring.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.spring.model.CitizenPlan;
import com.spring.search.Searchentity;

@Service
public interface CitizenService {
	public List<String> getPlan();
	public List<String> getstatus();
	public List<CitizenPlan> getSearchedrecorde(Searchentity search);
	public void saveExcel(HttpServletResponse response) throws IOException;
	public void savepdf(HttpServletResponse response) throws DocumentException, IOException;
	

}
