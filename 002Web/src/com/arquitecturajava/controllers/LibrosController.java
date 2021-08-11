package com.arquitecturajava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arquitecturajava.negocio.Libro;
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
		
		modelo.addAttribute("libros",servicio.buscarTodos());
		
		
		return "listalibros";
	}
	
	@RequestMapping("/formulariolibro")
	public String formularioLibro(Model modelo) {
		
			
		return "formulariolibro";
	}
	@RequestMapping(value="/insertarlibro",method=RequestMethod.POST)
	public String insertarlibro(Model modelo,Libro libro) {
		
		servicio.insertar(libro);
		modelo.addAttribute("libros",servicio.buscarTodos());
		
		
		return "listalibros";
	}
}
