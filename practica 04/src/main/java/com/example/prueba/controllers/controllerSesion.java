package com.example.prueba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controllerSesion {

	@RequestMapping(value="prueba", method = RequestMethod.POST)
	public String sesion(
			@RequestParam("userName") String userName,
			@RequestParam("userEmail") String userEmail,
			@RequestParam("userPassword") String userPassword, 
			Model model) {
		
		model.addAttribute("userName",userName);
		model.addAttribute("userEmail",userEmail);
		model.addAttribute("userPassword",userPassword);
		return "sesion";
	}
}
