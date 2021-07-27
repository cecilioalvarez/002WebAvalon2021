package com.arquitecturajavaJSP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavaJSP.repositorios.LibroRepository;
import com.arquitecturajavaJSP.repositorios.jdbc.Libro_RepositoryJDBC;
import com.arquitecturajavaJSP.negocio.Libro;


@WebServlet("/ServletUpdateJSP")
public class ServletUpdateJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroRepository repositorio = new Libro_RepositoryJDBC();
		Libro libro = new Libro(request.getParameter("isbn"), request.getParameter("autor"),request.getParameter("titulo"));
		
		repositorio.modifyBook(libro);
		response.sendRedirect("ListaLibrosJSP.jsp");
	}

}
