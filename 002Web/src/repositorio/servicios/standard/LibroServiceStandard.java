package repositorio.servicios.standard;

import java.util.List;

import org.springframework.stereotype.Service;

import negocio.Capitulo;
import negocio.Libro;
import repositorio.CapituloRepository;
import repositorio.LibroRepository;
import repositorio.servicios.LibroService;

@Service
public class LibroServiceStandard implements LibroService {

	private LibroRepository repositorio;
	private CapituloRepository repositorioCapitulo;

	public LibroServiceStandard(LibroRepository repositorio, CapituloRepository repositorioCapitulo) {
		super();
		this.repositorio = repositorio;
		this.repositorioCapitulo = repositorioCapitulo;
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

	@Override
	public List<Capitulo> buscarTodosLosCapitulos() {
		// TODO Auto-generated method stub
		return repositorioCapitulo.buscarTodos();
	}

	@Override
	public void borrarCapitulo(Capitulo capitulo) {
		// TODO Auto-generated method stub
		repositorioCapitulo.borrarCapitulo(capitulo);

	}

	@Override
	public void insertarCapitulo(Capitulo capitulo) {
		// TODO Auto-generated method stub
		repositorioCapitulo.insertarCapitulo(capitulo);

	}

	@Override
	public List<Capitulo> buscarTodosLosCapitulos(Libro libro) {
		// TODO Auto-generated method stub
		return repositorio.buscarTodosCapitulos(libro);
	}

}
