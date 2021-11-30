package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olamundo")
public class OlaMundo {
	
	@GetMapping
	public String mostra() {
		return "Olá mundo, as habilidades que estou usando no momento é atenção aos detalhes e mentalidade de orientação ao futuro";
	}
	
}
