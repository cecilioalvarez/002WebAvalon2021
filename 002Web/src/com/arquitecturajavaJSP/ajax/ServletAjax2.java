package com.arquitecturajavaJSP.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arquitecturajavaJSP.Spring.SpringConfigurador;
import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.repositorios.jdbc.Capitulo_RepositoryJDBC;
import com.arquitecturajavaJSP.repositorios.jdbc.Libro_RepositoryJDBC;
import com.arquitecturajavaJSP.servicios.LibroService;
import com.arquitecturajavaJSP.servicios.standard.LibroServiceStandard;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/ServletAjax2")
public class ServletAjax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Libro libro = new Libro("A1", "Pedro","Java" );
		//Libro libro2 = new Libro("A3", "Pedrito", "C#");
		
		//LibroService servicio = new LibroServiceStandard(new Libro_RepositoryJDBC(),new Capitulo_RepositoryJDBC());
		//Ahora se usa DataSource de Spring
		LibroService servicio;
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(SpringConfigurador.class);
		servicio = contexto.getBean(LibroServiceStandard.class);
		
		ObjectMapper mapeador = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//pw.print(mapeador.writeValueAsString(Arrays.asList(libro,libro2)));
		//pw.print(mapeador.writeValueAsString(servicio.buscarTodosLibros()));
		pw.print(mapeador.writeValueAsString(servicio.buscarTodosLibrosConCapitulos()));
		
	}

}
