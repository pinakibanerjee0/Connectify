package com.pinaki.connectify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pinaki.connectify.dao.UserRepositoy;
import com.pinaki.connectify.entities.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private UserRepositoy userRepo;

	@RequestMapping("/")
	public String home(Model m) {
		m.addAttribute("title", "This is home page of Connectify App");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("title", "This is about page of Connectify App");
		return "about";
	}

	@RequestMapping("/signUp")
	public String signUp( @ModelAttribute("user") User user , Model m) {
		m.addAttribute("title", "This is signUp page of Connectify App");
		m.addAttribute("user", new User());
		
		return "signUp";
	}

	@RequestMapping("/logIn")
	public String logIn(Model m) {
		m.addAttribute("title", "This is logIn page of Connectify App");
		return "logIn";
	}

	@RequestMapping( value ="/createUser" , method = RequestMethod.POST)
	public String createUser( @Valid @ModelAttribute("user") User user , Errors err , Model m ) {

		try {
			// create User Here and send him to login page
			System.out.println("user " + user);
			m.addAttribute("user", new User());
	
			if(err.hasErrors()) {
				System.out.println("Error is: "+err.toString());
				return "signUp";
			}
			user.setEnabled(true);
			user.setRole("USER");
			userRepo.save(user);
			m.addAttribute("regitrationSuccess", "Successfully Registered !!");
			return "logIn";
		} catch (Exception e) {
			System.out.println("catch executed...!");
			e.printStackTrace();
			m.addAttribute("errorMessage", e.getMessage());
			return "signUp";
		}
		
	}
}
