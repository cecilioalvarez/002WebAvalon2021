package com.arquitecturajavaJSP.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavaJSP.negocio.Libro;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/ServletAjax2")
public class ServletAjax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro libro = new Libro("A1", "Pedro","Java" );
		Libro libro2 = new Libro("A3", "Pedrito", "C#");
		ObjectMapper mapeador = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
		pw.print(mapeador.writeValueAsString(Arrays.asList(libro,libro2)));
		
	}

}
