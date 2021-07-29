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
	
		servicio = new LibroServiceStandard(new LibroRepositoryJDBC(), new CapituloRepositoryJDBC());
		
		List<Capitulo> capitulos = servicio.buscarTodosLosCapitulos();
		
		RequestDispatcher despachador = request.getRequestDispatcher("listacapitulos.jsp");
		request.setAttribute("capitulos", capitulos);
		despachador.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
