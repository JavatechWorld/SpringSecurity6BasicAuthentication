package com.codeWithRaman.implementation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@GetMapping("/admin/hello")
	public String sayHelloUser() {
		return "Hi, Admin with ROLE ADMIN.";
	}

}
