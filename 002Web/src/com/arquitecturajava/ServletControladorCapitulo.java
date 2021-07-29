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
 * Servlet implementation class ServletControladorCapitulo
 */
@WebServlet("/ServletControladorCapitulo")
public class ServletControladorCapitulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	LibroService servicio;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("accion")==null) {
			servicio = new LibroServiceStandard(new LibroRepositoryJDBC(), new CapituloRepositoryJDBC());
			
			List<Capitulo> capitulos = servicio.buscarTodosLosCapitulos();
			
			RequestDispatcher despachador = request.getRequestDispatcher("listacapitulos.jsp");
			request.setAttribute("capitulos", capitulos);
			despachador.forward(request, response);
		} else if(request.getParameter("accion").equals("borrar")) {
			
			servicio.borrarCapitulo(new Capitulo(request.getParameter("titulo")));
			response.sendRedirect("ServletControladorCapitulo");
			
		}else if(request.getParameter("accion").equals("formularioinsertar")) {
			
			RequestDispatcher despachador = request.getRequestDispatcher("formulariocapitulo.html");
			despachador.forward(request, response);
			
		}else if(request.getParameter("accion").equals("insertar")) {
			Capitulo c = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")), new Libro(request.getParameter("isbn")));
			servicio.insertarCapitulo(c);
			response.sendRedirect("ServletControladorCapitulo");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
