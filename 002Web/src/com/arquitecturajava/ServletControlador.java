package com.arquitecturajava;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.CapituloRepositoryJDBC;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.standard.LibroServiceStandard;
import com.arquitecturajava.spring.SpringConfigurador;

/**
 * Servlet implementation class ServletControlador
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LibroService servicio;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Aqui vemos como spring framework tiene un rol de factoria e instancia todos los objetos importantes
		//Con esta linea instanciamos los servicios y repositorios.
		AnnotationConfigApplicationContext contexto= new AnnotationConfigApplicationContext(SpringConfigurador.class);
		//servicio = contexto.getBean(LibroServiceStandard.class);
		//repositorioLibro = contexto.getBean(LibroRepositoryJDBC.class);
		//repositorioCapitulo = contexto.getBean(CapituloRepositoryJDBC.class);
		
		//Esto es como yo a una clase le inyecto otras dependencias
		//servicio = new LibroServiceStandard(repositorioLibro, repositorioCapitulo);
		servicio=contexto.getBean(LibroService.class);
		
		RequestDispatcher despachador = null;
		
		if (request.getParameter("accion") == null) {
			List<Libro> listaLibros = servicio.buscarTodos();
			request.setAttribute("libros", listaLibros);
			
			despachador = request.getRequestDispatcher("listalibros.jsp");
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("detalle")) {

			Libro libro =servicio.buscarUno(request.getParameter("isbn"));
			request.setAttribute("libro", libro);
			
			despachador = request.getRequestDispatcher("detalle.jsp");
			despachador.forward(request, response);
			
		}else if (request.getParameter("accion").equals("borrar")) {

			servicio.borrar(new Libro(request.getParameter("isbn")));
			response.sendRedirect("ServletControlador");
			
		}else if (request.getParameter("accion").equals("insertar")) {

			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");

			Libro libro = new Libro(isbn, titulo, autor);
			servicio.insertar(libro);

			response.sendRedirect("ServletControlador");

		}else if (request.getParameter("accion").equals("insertar2")) {

			String isbn1 = request.getParameter("isbn1");
			String titulo1 = request.getParameter("titulo1");
			String autor1 = request.getParameter("autor1");
			
			String isbn2 = request.getParameter("isbn2");
			String titulo2 = request.getParameter("titulo2");
			String autor2 = request.getParameter("autor2");

			Libro libro1 = new Libro(isbn1, titulo1, autor1);
			Libro libro2 = new Libro(isbn2, titulo2, autor2);
			//ervicio.insertar(libro);
			servicio.insertarVariosLibros(libro1,libro2);

			response.sendRedirect("ServletControlador");

		}else if (request.getParameter("accion").equals("actualizar")) {

			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");

			Libro libro = new Libro(isbn, titulo, autor);
			servicio.actualizar(libro);
			
			response.sendRedirect("ServletControlador");

		}else if (request.getParameter("accion").equals("formularioeditar")) {

			String isbn = request.getParameter("isbn");
			Libro libro = servicio.buscarUno(isbn);
			request.setAttribute("libro", libro);
	
			despachador = request.getRequestDispatcher("formularioeditar.jsp");
			despachador.forward(request, response);
			
		}else if (request.getParameter("accion").equals("capituloslibros")) {

			String isbn = request.getParameter("isbn");
			List<Capitulo> capitulos = servicio.buscarTodosCapitulos(new Libro(isbn));
			request.setAttribute("capitulos", capitulos);
			request.setAttribute("isbn", isbn);
			
			despachador = request.getRequestDispatcher("listacapitulos.jsp");
			despachador.forward(request, response);
			
		}else if (request.getParameter("accion").equals("formularioInsertarVarios")) {

			
			despachador = request.getRequestDispatcher("formularioLibros.html");
			despachador.forward(request, response);
			
		}else {

			despachador = request.getRequestDispatcher("formularioLibro.html");
			despachador.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
