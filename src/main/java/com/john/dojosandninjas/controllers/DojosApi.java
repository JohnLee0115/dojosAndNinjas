package com.john.dojosandninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.dojosandninjas.models.Dojo;
import com.john.dojosandninjas.services.DojoService;

@RestController
public class DojosApi {
	
	private final DojoService dojoService;
	
	public DojosApi(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/api/dojos")
	public List<Dojo> index() {
		return dojoService.allDojos();
	}
	
	@PostMapping("/api/dojos")
	public Dojo create(@RequestParam(value="name") String name) {
		Dojo dojo = new Dojo(name);
		
		return dojoService.createDojo(dojo);
	}
	
	@RequestMapping("/api/dojos/{id}")
	public Dojo show(@PathVariable("id") Long id) {
		Dojo dojo = dojoService.findDojo(id);
		
		return dojo;
	}
	
	
}
