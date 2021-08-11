package com.arquitecturajavaJSP.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.servicios.LibroService;

@Controller
@RequestMapping("/libros/{isbn}/capitulos-libro")
public class CapitulosController {
	
	private LibroService servicio;

	public CapitulosController(LibroService service) {
		super();
		this.servicio = service;
	}

	
	@RequestMapping("/nuevo")
	public String formulario(Model modelo,@PathVariable String isbn) {
		
		modelo.addAttribute("miIsbn",isbn);
		return "formularioCapitulo";
		
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String insertar(Model modelo,Capitulo chapter,@PathVariable String isbn) {
		
		chapter.setLibro(new Libro(isbn));
		servicio.addChapter(chapter);
		
		Libro libro = servicio.buscarLibro(chapter.getLibro().getIsbn());
		libro.setListacoCapitulos(servicio.buscarTodosCapitulos(new Libro(chapter.getLibro().getIsbn())));
		
		modelo.addAttribute("libro",libro);
		
		return "redirect: ../detalle";
	}
	
	@RequestMapping("/borrar")
	public String borrarCapitulo(Model modelo,@PathVariable String isbn,String titulo) {
		
		servicio.removeChapter(new Capitulo(titulo,new Libro(isbn)));
		
		return "redirect: ../detalle";
	}
	
	@RequestMapping("/detalle")
	public String detalleChapter(Model modelo,@PathVariable String isbn,String titulo) {
		
		modelo.addAttribute("chapter",servicio.getOneChapter(new Capitulo(titulo, new Libro(isbn))));
		
		return "detalleCapitulo";
	}
	
	@RequestMapping("/editar")
	public String formModificarCapitulo(Model modelo,String titulo,@PathVariable String isbn) {
		modelo.addAttribute("miCapitulo",servicio.getOneChapter(new Capitulo(titulo, new Libro(isbn))));
		
		return "modificarCapitulo";
	}
	
	@RequestMapping(value="/salvar",method=RequestMethod.POST)
	public String salvarCapitulo(Model modelo,Capitulo chapter,@PathVariable String isbn) {
		chapter.setLibro(new Libro(isbn));
		servicio.modifyChapter(chapter);
		
		return "redirect: ../detalle";
	}
}
