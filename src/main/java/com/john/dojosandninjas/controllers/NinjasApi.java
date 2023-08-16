package com.john.dojosandninjas.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.dojosandninjas.models.Dojo;
import com.john.dojosandninjas.models.Ninja;
import com.john.dojosandninjas.services.NinjaService;

@RestController
public class NinjasApi {
	
	private final NinjaService ninjaService;
	
	public NinjasApi(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	
	@PostMapping("/api/ninjas")
	public Ninja create( @RequestParam(value="firstName") String firstName,
						 @RequestParam(value="lastName") String lastName,
						 @RequestParam(value="age") int age,
						 @RequestParam(value="dojo") Dojo dojo) {
		Ninja ninja = new Ninja(firstName, lastName, age, dojo);
		
		return ninjaService.createNinja(ninja);
	}

}
