package arquitecturaspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
