package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ServletJajax2
 */
@WebServlet("/ServletAjax2")
public class ServletAjax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro l=new Libro("1a","java","pedro");
		ObjectMapper mapeador=new ObjectMapper();
		PrintWriter pw=response.getWriter();
		pw.print(mapeador.writeValueAsString(l));
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
