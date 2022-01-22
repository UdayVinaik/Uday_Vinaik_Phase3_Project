package com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RootController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/dashboard")
	public String goToDashboard (
			@RequestParam(value="name", required= true) String name,
			@RequestParam(value="email", required = false) String email,
			Model model
			) {
		if (name.equals("uday")) {
			return "dashboard";
		}
		return "index";
	}
	
}
