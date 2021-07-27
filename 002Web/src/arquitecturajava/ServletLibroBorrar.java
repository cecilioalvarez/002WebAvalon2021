package arquitecturajava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Libro;
import repositorio.jdbc.helper.LibroRepositoryJDBC;
import repositorio.servicios.LibroService;
import repositorio.servicios.standard.LibroServiceStandard;

/**
 * Servlet implementation class ServletLibroBorrar
 */
@WebServlet("/ServletLibroBorrar")
public class ServletLibroBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibroService repositorio = new LibroServiceStandard(new LibroRepositoryJDBC());
		repositorio.borrar(new Libro(request.getParameter("isbn")));
		response.sendRedirect("ListaLibrosJSP.jsp");
	}

}
