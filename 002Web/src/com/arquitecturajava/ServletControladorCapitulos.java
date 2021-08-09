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
import com.arquitecturajava.repositorios.jdbc.CapituloRepositoryJDBC;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.standard.LibroServiceStandard;
import com.arquitecturajava.spring.SpringConfigurador;

/**
 * Servlet implementation class ServletControladorCapitulos
 */
@WebServlet("/ServletControladorCapitulos")
public class ServletControladorCapitulos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LibroService servicio;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AnnotationConfigApplicationContext contexto= new AnnotationConfigApplicationContext(SpringConfigurador.class);
		servicio=contexto.getBean(LibroServiceStandard.class);
		
		//servicio = new LibroServiceStandard(new LibroRepositoryJDBC(), new CapituloRepositoryJDBC());

		if (request.getParameter("accion") == null) {

			List<Capitulo> capitulos = servicio.buscarTodosLosCapitulos();

			RequestDispatcher despachador = request.getRequestDispatcher("listacapitulos.jsp");
			request.setAttribute("capitulos", capitulos);
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("borrar")) {

			servicio.borrarCapitulo(new Capitulo(request.getParameter("titulo")));
			String isbn=request.getParameter("isbn");
			response.sendRedirect("ServletControlador?accion=capituloslisbros&isbn="+isbn);
			
			
		}else if (request.getParameter("accion").equals("formularioinsertar")) {

			RequestDispatcher despachador = request.getRequestDispatcher("formulariocapitulo.jsp");
			request.setAttribute("isbn", request.getParameter("isbn"));
		
			despachador.forward(request, response);

		}else if (request.getParameter("accion").equals("insertar")) {
			
			Capitulo c= new Capitulo(request.getParameter("titulo"),Integer.parseInt(request.getParameter("paginas")),new Libro(request.getParameter("isbn")));
			servicio.insertarCapitulo(c);
			String isbn = request.getParameter("isbn");
			response.sendRedirect("ServletControlador?accion=capituloslibros&isbn="+isbn);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
