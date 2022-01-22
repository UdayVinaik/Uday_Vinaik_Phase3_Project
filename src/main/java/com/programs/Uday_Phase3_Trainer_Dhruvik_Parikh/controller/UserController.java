package com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.dao.UserDao;
import com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	
	@GetMapping("/listUsers")
	public String listUsers(Model model) {
		
		List<User> users =  userDao.getUsers();
		System.out.print(users);
		model.addAttribute("users",users);
		return "listUsers";
	}
	
	@RequestMapping("/searchUser")
	public String searchUser(
			@RequestParam(value = "user", required = true) String user,
			Model model
			) {
		List<User> users = userDao.searchUser(user);
		model.addAttribute("users", users);
		return "listUsers";
	}
}
