package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import negocio.Libro;

/**
 * Servlet implementation class ServletAjax2
 */
@WebServlet("/ServletAjax2")
public class ServletAjax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Libro libro = new Libro("la", "java", "web");
		Libro libro2 = new Libro("la", "java", "web");
		ObjectMapper mapeador = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		pw.println(mapeador.writeValueAsString(Arrays.asList(libro, libro2)));
	}



}
