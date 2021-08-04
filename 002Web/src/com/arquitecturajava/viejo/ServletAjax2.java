package com.arquitecturajava.viejo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.jdbc.CapituloRepositoryJDBC;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.standard.LibroServiceStandard;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ServletAjax
 */
@WebServlet("/ServletAjax2")
public class ServletAjax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro l = new Libro("1a","java","pedro");
		Libro l2 = new Libro("2a","php","ana");
		
		/*ObjectMapper mapeador = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		pw.print(mapeador.writeValueAsString(Arrays.asList(l,l2)));*/
		
		LibroService servicio = new LibroServiceStandard(new LibroRepositoryJDBC(),new CapituloRepositoryJDBC());
		List<Libro> listaLibros = servicio.buscarTodos();
		ObjectMapper mapeador = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		pw.print(mapeador.writeValueAsString(listaLibros));
	}
}
