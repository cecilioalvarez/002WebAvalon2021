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

/**
 * Servlet implementation class ServletActualizar
 */
@WebServlet("/ServletActualizar")
public class ServletActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroRepository repositorio= new LibroRepositoryJDBC();
		Libro libro =new Libro(request.getParameter("isbn"),request.getParameter("titulo"),request.getParameter("autor"));
		repositorio.actualizar(libro);
		response.sendRedirect("listalibros.jsp");
	}

}
