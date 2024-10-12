package com.ust.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/rest/service1")
public class HelloController {
	
	@Autowired
	Environment environment;
	
	@GetMapping("/test")
	public String confirm() {
		return "hello service connected and responding from port "+environment.getProperty("local.server.port");
	}
	
	@GetMapping("/time")
	public String time() {
		return new Date().toString();
	}
	

}
