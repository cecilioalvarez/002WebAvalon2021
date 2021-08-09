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
import com.arquitecturajavaspring.SpringConfigurador;

@WebServlet("/ServletControladorCapitulos")
public class ServletControladorCapitulos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LibroService servicio;
	LibroRepository repositorioLibro;
	CapituloRepository repositorioCapitulo;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(SpringConfigurador.class);

		// servicio=contexto.getBean(LibroServiceStandard.class);
		// repositorioLibro=contexto.getBean(LibroRepositoryJDBC.class);
		// repositorioCapitulo=contexto.getBean(CapituloRepositoryJDBC.class);

		servicio = contexto.getBean(LibroServiceStandard.class);

		RequestDispatcher despachador;

		if (request.getParameter("accion") == null) {

			List<Capitulo> listaCapitulos = servicio.buscarTodosLosCapitulos();

			despachador = request.getRequestDispatcher("listaCapitulos.jsp");
			request.setAttribute("capitulos", listaCapitulos);
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("borrar")) {

			servicio.borrarCapitulo(new Capitulo(request.getParameter("titulo")));
			String isbn = request.getParameter("isbn");
			response.sendRedirect("ServletControlador?accion=capituloslibros&isbn=" + isbn);

		} else if (request.getParameter("accion").equals("formularioInsertar")) {

			despachador = request.getRequestDispatcher("formularioCapitulo.jsp");
			request.setAttribute("isbn", request.getAttribute("isbn"));
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("insertar")) {

			Capitulo c = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")),
					new Libro(request.getParameter("isbn")));
			servicio.insertarCapitulo(c);
			String isbn = request.getParameter("isbn");
			response.sendRedirect("ServletControlador?accion=capituloslibros&isbn=" + isbn);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
