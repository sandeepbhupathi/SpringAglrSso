package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAngularNewApplication {
	
	@RequestMapping(value="/sayHello",method=RequestMethod.GET)
	public String sayHello(){
		return "Hello Sandeep";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringAngularNewApplication.class, args);
	}
}
