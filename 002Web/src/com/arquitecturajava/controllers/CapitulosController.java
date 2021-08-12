package com.arquitecturajava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.servicios.LibroService;

@Controller
@RequestMapping("/libros")
public class CapitulosController {

	private LibroService servicio;
	
	public CapitulosController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping("/{isbn}/capitulos/nuevo")
	public String formulario(Model modelo,@PathVariable String isbn) {
		
		modelo.addAttribute("isbn", isbn);
		return "formulariocapitulo";
	}
	
	@RequestMapping(value="/{isbn}/capitulos/insertar",method=RequestMethod.POST)
	public String insertar(Model modelo,Capitulo capitulo, @PathVariable String isbn) {
		
		capitulo.setLibro(new Libro(isbn));
		servicio.insertarCapitulo(capitulo);
		return "redirect: ../capitulos";
	}
	
	@RequestMapping(value="/{isbn}/capitulos/borrar")
	public String borrar(Model modelo,String titulo, @PathVariable String isbn) {
		
		Capitulo c= new Capitulo();
		c.setTitulo(titulo);
		
		servicio.borrarCapitulo(c);
		return "redirect: ../capitulos";
	}
}
