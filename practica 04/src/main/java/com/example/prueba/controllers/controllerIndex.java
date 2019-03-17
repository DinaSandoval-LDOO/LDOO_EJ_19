package com.example.prueba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerIndex {

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
