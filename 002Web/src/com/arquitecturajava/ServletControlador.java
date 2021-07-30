package com.arquitecturajava;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.jdbc.CapituloRepositoryJDBC;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.standard.LibroServiceStandard;

/**
 * Servlet implementation class ServletControlador
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	LibroService servicio;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		servicio = new LibroServiceStandard(new LibroRepositoryJDBC(), new CapituloRepositoryJDBC());
		RequestDispatcher despachador = null;
		if (request.getParameter("accion") == null) {

			List<Libro> listaLibros = servicio.buscarTodos();
			request.setAttribute("libros", listaLibros);
			
			despachador = request.getRequestDispatcher("listalibros.jsp");
			//reenvida los datos del primer servlet controlador al jsp para que renderize
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("borrar")) {

			servicio.borrar(new Libro(request.getParameter("isbn")));
			response.sendRedirect("ServletControlador");
			
			
		}else if (request.getParameter("accion").equals("detalle")) {

			Libro libro = servicio.buscarUno(request.getParameter("isbn"));
			request.setAttribute("libro", libro);
			despachador = request.getRequestDispatcher("detalle.jsp");
			despachador.forward(request, response);
			
		} else if (request.getParameter("accion").equals("insertar")) {

			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");

			Libro libro = new Libro(isbn, titulo, autor);
			servicio.insertar(libro);

			response.sendRedirect("ServletControlador");

		}else if (request.getParameter("accion").equals("actualizar")) {

			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");

			Libro libro = new Libro(isbn, titulo, autor);
			servicio.actualizar(libro);
			System.out.println("entro por actualizar");
			response.sendRedirect("ServletControlador");

		}else if (request.getParameter("accion").equals("formularioeditar")) {
		
			System.out.println("entro por formularioeditar");
			String isbn = request.getParameter("isbn");
			Libro libro = servicio.buscarUno(isbn);
			request.setAttribute("libro", libro);
	
			despachador = request.getRequestDispatcher("formularioeditar.jsp");
			despachador.forward(request, response);

		}else if (request.getParameter("accion").equals("capituloslibros")) {
		
			String isbn = request.getParameter("isbn");
			List<Capitulo> capitulos = servicio.buscarTodosCapitulos(new Libro(isbn));
			request.setAttribute("capitulos", capitulos);
	
			despachador = request.getRequestDispatcher("listacapitulos.jsp");
			despachador.forward(request, response);

		} else {

			despachador = request.getRequestDispatcher("FormularioLibro.html");
			despachador.forward(request, response);
		}

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
