package arquitecturaspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/lista")
	public String listaLibros(Model modelo) {
		modelo.addAttribute("libros", service.buscarTodos());
		return "listaLibros";
	}

	@RequestMapping("/nuevo")
	public String formularioLibro(Model modelo) {
		return "formulariolibro";
	}

	@RequestMapping(value = "/insertarlibro", method = RequestMethod.POST)
	public String insertarLibro(Model modelo, Libro libro) {
		service.insertar(libro);
		return "redirect:lista";
	}

	@RequestMapping("/borrar")
	public String borrarLibro(Model modelo, String isbn) {
		service.borrar(new Libro(isbn));
		return "redirect:lista";
	}
	
	@RequestMapping("/detalle")
	public String detalleLibro(Model modelo, String isbn) {
		modelo.addAttribute("libro", service.buscarUno(isbn));
		return "detalle";
	}
	
	@RequestMapping("/editar")
	public String formularioEditar(Model modelo, String isbn) {
		modelo.addAttribute("libro", service.buscarUno(isbn));
		return "formularioEditar";
	}
	
	@RequestMapping(value = "/actualizarlibro", method = RequestMethod.POST)
	public String actualizarlibro(Model modelo, Libro libro) {

		service.actualizar(libro);
		return "redirect:lista";
	}
	@RequestMapping("/{isbn}/capitulos")
	public String verCapitulos(Model modelo,@PathVariable String isbn) {

		modelo.addAttribute("isbn",isbn);
		modelo.addAttribute("capitulos",service.buscarTodosLosCapitulos(new Libro(isbn)));
		return "listaCapitulos";
	}

}
