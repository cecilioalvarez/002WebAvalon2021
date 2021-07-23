package arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDinamico
 */
@WebServlet("/ServletDinamico")
public class ServletDinamico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tope = Integer.parseInt(request.getParameter("numero"));
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		for (int i = 0; i <= tope; i++) {
			writer.println("<p>" + i + "</p>");

		}
		writer.println("</body></html>");
	}

}
