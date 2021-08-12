package com.arquitecturajava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("/lista")
	public String lista(Model modelo) {
		modelo.addAttribute("libros", servicio.buscarTodos());
		return "listalibros";
	}
	@RequestMapping("/detalle")
	public String detalleLibro(Model modelo, String isbn) {
		//Estas dos lineas serian igual que la linea de abajo
		//Libro libro = servicio.buscarUno(isbn);
		//modelo.addAttribute("libro", libro);
		modelo.addAttribute("libro", servicio.buscarUno(isbn));
		return "detallelibro";
	}
	@RequestMapping("/borrar")
	public String borrar(Model model, String isbn) {
		servicio.borrar(new Libro(isbn));
		return "redirect:lista";
	}
	@RequestMapping("/nuevo")
	public String formularioLibro(Model model) {
		return "formulariolibro";
	}
	@RequestMapping(value= "/insertar", method=RequestMethod.POST)
	public String insertarLibro(Model modelo, Libro libro) {
		servicio.insertar(libro);
		//La siguiente linea no es necesaria ya que hacemos un redirect. Si solo devolvieramos listalibros seria necesaria
		//modelo.addAttribute("libros", servicio.buscarTodos());
		return "redirect:lista";
	}
	
	
	@RequestMapping("/editar")
	public String formularioEditar(Model modelo, String isbn) {
		modelo.addAttribute("libro", servicio.buscarUno(isbn));
		return "formularioeditar";
	}
	@RequestMapping(value= "/salvar", method=RequestMethod.POST)
	public String salvarLibro(Model modelo, Libro libro) {
		servicio.actualizar(libro);
		return "redirect:lista";
	}
	@RequestMapping("/{isbn}/capitulos")
	public String verCapitulos(Model modelo,@PathVariable String isbn) {
		//List<Capitulo> capitulos = servicio.buscarTodosCapitulos(libro);
		modelo.addAttribute("isbn", isbn);
		modelo.addAttribute("capitulos", servicio.buscarTodosCapitulos(new Libro(isbn)));
		return "listacapitulos";
	}
	

	
}
