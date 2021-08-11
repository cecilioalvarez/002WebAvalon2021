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
	
	@RequestMapping("/detallelibro")
	public String detallelibro(Model modelo,String isbn) {
		
		Libro libro= servicio.buscarUno(isbn);
		// aqui es como cuando pasabamos en el request el setattribute
		
		modelo.addAttribute("libro",libro);
		
		return "detallelibro";
	}
	
	
	@RequestMapping("/borrarlibro")
	public String borrarlibro(Model modelo,String isbn) {
		
		servicio.borrar(new Libro(isbn));
		return "redirect:listalibros";
	}
	@RequestMapping("/formularioeditar")
	public String formularioEditar(Model modelo,String isbn) {
		
		Libro libro= servicio.buscarUno(isbn);
		// aqui es como cuando pasabamos en el request el setattribute
		
		modelo.addAttribute("libro",libro);
			
		return "formularioeditar";
	}
	
	@RequestMapping("/formulariolibro")
	public String formularioLibro(Model modelo) {
		
			
		return "formulariolibro";
	}
	@RequestMapping(value="/insertarlibro",method=RequestMethod.POST)
	public String insertarlibro(Model modelo,Libro libro) {
		
		servicio.insertar(libro);
		//aqui tenia buscar libros un addattribute
		return  "redirect:listalibros";
	}
}
