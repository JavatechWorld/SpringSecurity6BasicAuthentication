package com.codeWithRaman.implementation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user/hello")
	public String sayHelloUser() {
		return "Hi, User with ROLE USER.";
	}

}
