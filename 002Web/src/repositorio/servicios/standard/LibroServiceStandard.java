package repositorio.servicios.standard;

import java.util.List;

import negocio.Libro;
import repositorio.LibroRepository;
import repositorio.servicios.LibroService;

public class LibroServiceStandard implements LibroService {

	private LibroRepository repositorio;

	public LibroServiceStandard(LibroRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public void actualizar(Libro libro) {
		repositorio.actualizar(libro);
	}

	@Override
	public void insertar(Libro libro) {
		repositorio.insertar(libro);
	}

	@Override
	public void borrar(Libro libro) {
		repositorio.borrar(libro);
	}

	@Override
	public List<Libro> buscarTodos() {
		return repositorio.buscarTodos();
	}

	@Override
	public List<Libro> buscarTodosConCapitulos() {
		return repositorio.buscarTodosConCapitulos();
	}

	@Override
	public List<Libro> buscarTituloyAutor(String titulo, String autor) {
		return repositorio.buscarTituloyAutor(titulo, autor);
	}

	@Override
	public Libro buscarUno(String isbn) {
		return repositorio.buscarUno(isbn);
	}

}
