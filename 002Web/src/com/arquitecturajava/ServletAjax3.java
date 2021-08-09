package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.CapituloRepositoryJDBC;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.standard.LibroServiceStandard;
import com.arquitecturajavaspring.SpringConfigurador;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ServletAjax3
 */
@WebServlet("/ServletAjax3")
public class ServletAjax3 extends HttpServlet {
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
		List<Libro> listaLibros = servicio.buscarTodos();

		ObjectMapper mapeador = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		pw.print(mapeador.writeValueAsString(listaLibros));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
