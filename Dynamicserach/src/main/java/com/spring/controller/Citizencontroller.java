package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.service.CitizenServicImpl;

@Controller
public class Citizencontroller {
	
	@Autowired
	private CitizenServicImpl citizenservice;
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

}
