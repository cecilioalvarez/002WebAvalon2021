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
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.CapituloRepositoryJDBC;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.standard.LibroServiceStandard; 


@WebServlet("/ServletControladorCapitulos")
public class ServletControladorCapitulos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LibroService servicio; 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servicio = new LibroServiceStandard(new LibroRepositoryJDBC(),new CapituloRepositoryJDBC());
		RequestDispatcher despachador;
		if (request.getParameter("accion") == null) {

			List<Capitulo> listaCapitulos= servicio.buscarTodosLosCapitulos();
			
			despachador = request.getRequestDispatcher("listaCapitulos.jsp");
			request.setAttribute("capitulos", listaCapitulos);
			despachador.forward(request, response);

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}