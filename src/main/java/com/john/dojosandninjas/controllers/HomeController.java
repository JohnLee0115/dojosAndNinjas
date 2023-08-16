package com.john.dojosandninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.john.dojosandninjas.models.Dojo;
import com.john.dojosandninjas.models.Ninja;
import com.john.dojosandninjas.services.DojoService;
import com.john.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	private final DojoService dojoService;
	
	private final NinjaService ninjaService;
	
	public HomeController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/dojos/new")
	public String dojos(@ModelAttribute("dojo") Dojo dojo) {
		return "NewDojo.jsp";
	}
	
	@PostMapping("/dojos/new/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "NewDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@GetMapping("ninjas/new")
	public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "NewNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "NewNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/dojos/{dojo_id}")
	public String showDojo(@PathVariable("dojo_id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute(dojo);
		return "ShowDojo.jsp";
	}
	
}














