package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olamundo")
public class OlaMundo {

	@GetMapping
	public String mostra() {
		return "Meus objetivos é aprender springbot e conseguir usa-lo da melhor forma possível";
	}
}
