package arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Libro;
import repositorio.LibroRepository;
import repositorio.jdbc.helper.LibroRepositoryJDBC;
import repositorio.servicios.LibroService;
import repositorio.servicios.standard.LibroServiceStandard;

/**
 * Servlet implementation class ServletLibro
 */
@WebServlet("/ServletLibro")
public class ServletLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		Libro libro = new Libro(isbn, titulo, autor);
		LibroService repositorio = new LibroServiceStandard(new LibroRepositoryJDBC());
		repositorio.insertar(libro);
		response.sendRedirect("ListaLibrosJSP.jsp");

	}

}
