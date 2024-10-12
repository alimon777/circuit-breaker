package com.ust.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/client")
public class HelloController {
	
	@Autowired
	RestTemplate template;
	
	public final static String CLIENT_SERVICE="clientService";
	
	@GetMapping
	@CircuitBreaker(name=CLIENT_SERVICE,fallbackMethod="callOnFail")
	public String callServer() {
		String url = "http://localhost:8099/rest/service1/test";
		String output = template.getForObject(url, String.class);
		return output;
	}
	
	public String callOnFail(Exception e) {
		return "message from callOnFail()....";
	}

}
