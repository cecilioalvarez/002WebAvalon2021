package com.arquitecturajava;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.standard.LibroServiceStandard;

/**
 * Servlet implementation class ServletLibroBorrar
 */
@WebServlet("/ServletLibroBorrar")
public class ServletLibroBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LibroService servicio= new LibroServiceStandard(new LibroRepositoryJDBC());
		servicio.borrar(new Libro(request.getParameter("isbn")));
		response.sendRedirect("listalibros.jsp");
	
	}

}
