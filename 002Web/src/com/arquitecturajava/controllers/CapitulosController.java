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
@RequestMapping("/libros/{isbn}/capitulos/")
public class CapitulosController {
	
	private LibroService servicio;
	
	public CapitulosController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping("nuevo")
	public String formulario(Model modelo, @PathVariable String isbn) {
		modelo.addAttribute("isbn", isbn);
		return "formulariocapitulo";
	}
	@RequestMapping(value= "insertar",  method=RequestMethod.POST)
	public String insertar(Model modelo, Capitulo capitulo, @PathVariable String isbn) {
		capitulo.setLibro(new Libro(isbn));
		servicio.insertarCapitulo(capitulo);
		return "redirect:../capitulos";
	}
	
	@RequestMapping(value= "borrar")
	public String borrar(Model modelo, String titulo, @PathVariable String isbn) {
		//Creamos un capitulo
		Capitulo c = new Capitulo();
		//Asignamos titulo
		c.setTitulo(titulo);
		//Utilizamos el metodo borrar del servicio y le pasamos el capitulo
		servicio.borrarCapitulo(c);
		//return "redirect:../../capitulos-libro?isbn="+isbn;
		return "redirect:../capitulos";
	}
}
