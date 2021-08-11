package com.arquitecturajavaJSP.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.servicios.LibroService;

@Controller
@RequestMapping("/libros")
public class LibrosController {
	private LibroService servicio;
	
	
	public LibrosController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}


	@RequestMapping("/lista")
	public String lista(Model modelo) {
		
		modelo.addAttribute("libros",servicio.buscarTodosLibros());
		
		return "listalibros";
	}
	
	@RequestMapping("/nuevo")
	public String addNuevoLibro(Model modelo) {
		
		return "formularioLibro";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String insertarLibro(Model modelo,Libro libro) {
		
		servicio.addBook(libro);
		
		//return "listalibros";
		return "redirect:lista";
	}
	
	@RequestMapping(value="/borrar",method=RequestMethod.GET)
	public String borrarLibro(Model modelo,String isbn) {
		servicio.removeBook(new Libro(isbn));
		
		return "redirect:lista";
	}
	
	@RequestMapping("/detalle")
	public String detalleLibro(Model modelo,String isbn) {
		Libro libro = servicio.buscarLibro(isbn);
		libro.setListacoCapitulos(servicio.buscarTodosCapitulos(new Libro(isbn)));
		
		modelo.addAttribute("libro",libro);
		
		return "detalleLibro";
	}
	
	@RequestMapping("/editar")
	public String formModificarLibro(Model modelo,String isbn) {
		modelo.addAttribute("milibro",servicio.buscarLibro(isbn));
		
		return "modificarLibro";
	}
	
	@RequestMapping(value="/modificado",method=RequestMethod.POST)
	public String modificarLibro(Model modelo,Libro libro) {
		servicio.modifyBook(libro);
		
		return "redirect:lista";
	}
	
}
