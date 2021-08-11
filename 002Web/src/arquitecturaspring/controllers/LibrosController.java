package arquitecturaspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import negocio.Libro;
import repositorio.servicios.LibroService;

@Controller
@RequestMapping("/libros")
public class LibrosController {
	private LibroService service;

	public LibrosController(LibroService service) {
		super();
		this.service = service;
	}

	@RequestMapping("/listaLibros")
	public String listaLibros(Model modelo) {
		modelo.addAttribute("libros", service.buscarTodos());
		return "listaLibros";
	}

	@RequestMapping("/formulariolibro")
	public String formularioLibro(Model modelo) {
		return "formulariolibro";
	}

	@RequestMapping(value = "/insertarlibro", method = RequestMethod.POST)
	public String insertarLibro(Model modelo, Libro libro) {
		service.insertar(libro);
		return "redirect:listaLibros";
	}

	@RequestMapping("/borrarlibro")
	public String borrarLibro(Model modelo, String isbn) {
		service.borrar(new Libro(isbn));
		return "redirect:listaLibros";
	}
	
	@RequestMapping("/detallelibro")
	public String detalleLibro(Model modelo, String isbn) {
		modelo.addAttribute("libro", service.buscarUno(isbn));
		return "detalle";
	}

}
