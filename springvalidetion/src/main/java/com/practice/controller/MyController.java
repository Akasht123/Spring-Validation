package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.entity.LoginData;

import jakarta.validation.Valid;

@Controller
public class MyController {
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String openForm(Model model ) {
		
		model.addAttribute("loginData", new LoginData());
		System.out.println("opening form");
		return "form";
	}
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData ,BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result);
		}
		System.out.println(loginData);
		return"success";
	}

}
