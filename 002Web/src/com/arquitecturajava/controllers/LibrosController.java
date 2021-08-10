package com.arquitecturajava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arquitecturajava.servicios.LibroService;

@Controller
@RequestMapping("/libros")
public class LibrosController {

	private LibroService servicio;
	
	
	public LibrosController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}


	@RequestMapping("/listalibros")
	public String listaLibros(Model modelo) {
		
		modelo.addAttribute("libros", servicio.buscarTodos());
		return "listalibros";
	}
}
