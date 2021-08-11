package com.arquitecturajava.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arquitecturajava.servicios.LibroService;

@RequestMapping("/libros")
public class CapitulosController {

	private LibroService servicio;
	
	public CapitulosController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping("/{isbn}/capitulos/formulario")
	public String formulario(Model modelo,@PathVariable String isbn) {
		
		modelo.addAttribute("isbn", isbn);
		return "formulariocapitulo";
	}
	
}
