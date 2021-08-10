package com.arquitecturajavaJSP.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libros")
public class LibrosController {
	@RequestMapping("/lista")
	public String listaLibros() {
		return "listalibros";
	}
	
}
