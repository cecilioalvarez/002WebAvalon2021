package com.arquitecturajava;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servicio = new LibroServiceStandard(new LibroRepositoryJDBC());
		List<Libro> listaLibros = servicio.buscarTodos();
		//queremos volver a la lista de libros
		RequestDispatcher despachador = request.getRequestDispatcher("listalibros.jsp");
		//lista de libros pasarle unos datos en este caso una lista de libros
		//a traves de la peticion adjuntamos los datos
		request.setAttribute("libros", listaLibros);
		//reenviamos todo a esta vista
		despachador.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
