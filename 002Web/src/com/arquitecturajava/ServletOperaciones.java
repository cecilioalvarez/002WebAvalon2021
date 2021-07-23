package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletOperaciones")
public class ServletOperaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double num1= Double.parseDouble(request.getParameter("numero1"));
		double num2= Double.parseDouble(request.getParameter("numero2"));
		PrintWriter writer=response.getWriter();
		writer.write("<html><body>");
		writer.write("<p>Numero 1: "+num1+" / Numero 2: "+num2+"</p>");
		writer.write("<p>Suma: "+(num1+num2)+"</p>");
		writer.write("<p>Resta: "+(num1-num2)+"</p>");
		writer.write("<p>Multiplicacion: "+(num1*num2)+"</p>");
		writer.write("</body></html>");
	}

}
