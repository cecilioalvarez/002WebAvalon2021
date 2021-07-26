package viejo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletEjercicio2")
public class ServletEjercicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numero1=Integer.parseInt(request.getParameter("numero1"));
		int numero2=Integer.parseInt(request.getParameter("numero2"));
		PrintWriter writer=response.getWriter();
		writer.write("<html><body>");
		writer.write("<p>La suma de "+ numero1 + " y "+ numero2+" es "+numero1+numero2+"</p>");
//		writer.write("<p>La resta de "+ numero1 + "y "+ numero2+" es "+numero1-numero2+"</p>");
		writer.write("<p>La multiplicacion de "+ numero1 + " y "+ numero2+" es "+numero1*numero2+"</p>");
		
		writer.write("</body></html>");
		
		
	}


}
