package old;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCalculadora
 */
@WebServlet("/ServletCalculadora")
public class ServletCalculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		int resultado = 0;
		String operacion = request.getParameter("operacion");
		int number1 = 0;
		int number2 = 0;

		if (request.getParameter("number1").chars().allMatch(Character::isDigit) && request.getParameter("number2").chars().allMatch(Character::isDigit)) {

			number1 = Integer.parseInt(request.getParameter("number1"));
			number2 = Integer.parseInt(request.getParameter("number2"));

		}
		

		switch (operacion) {
		case "+":
			resultado = number1 + number2;
			break;
		case "-":
			resultado = number1 - number2;
			break;
		case "/":
			resultado = number1 / number2;
			break;
		case "*":
			resultado = number1 * number2;
			break;

		default:
			break;
		}

		writer.println("<html><body>El resultado de la operacion es: " + resultado + "</html></body>");
	}

}
