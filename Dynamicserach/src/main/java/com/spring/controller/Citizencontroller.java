package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lowagie.text.DocumentException;
import com.spring.model.CitizenPlan;
import com.spring.search.Searchentity;
import com.spring.service.CitizenServicImpl;

@Controller
public class Citizencontroller {
	
	@Autowired
	private CitizenServicImpl citizenservice;
	
	
	public void formInit(Model model) {
		List<String> plan = citizenservice.getPlan();
		List<String> status = citizenservice.getstatus();
		List<String> gender=citizenservice.getGender();
		
		model.addAttribute("planName",plan);
		model.addAttribute("planStatus", status);
		model.addAttribute("Gender", gender);
	}
	@GetMapping("/")
	public String index(Model model) {
		
		formInit(model);
		
		model.addAttribute("search", new Searchentity());
		
		return "index";
		
	}
	
	@PostMapping("/filter-data")
	public String formhalding(@ModelAttribute("search")Searchentity entity,Model model){
		
		System.out.println(entity);
		List<CitizenPlan> searchedrecorde = citizenservice.getSearchedrecorde(entity);
		model.addAttribute("citizens", searchedrecorde);
		formInit(model);
		return "index";
		
	}
	@GetMapping("/excel")
	public String downloadExcel(HttpServletResponse response) throws IOException, MessagingException {
		citizenservice.saveExcel(response);
		
		
		return "forward:/index";
		
	}
	public String Uerslist(){
		return "forward:/index";
		
	}
	
	@GetMapping("/pdf")
	public void downloadUserPdf(HttpServletResponse response) throws IOException, DocumentException {
		citizenservice.savepdf(response);
	}

}
