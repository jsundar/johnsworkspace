package com.people.systems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/api/v1/welcome")
	public String displayMessage() {
		return "Hello World";
	}

}
