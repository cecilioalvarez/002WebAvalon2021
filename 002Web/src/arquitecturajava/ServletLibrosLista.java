package arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Libro;
import repositorio.LibroRepository;
import repositorio.jdbc.helper.LibroRepositoryJDBC;

/**
 * Servlet implementation class ServletLibrosLista
 */
@WebServlet("/ServletLibrosLista")
public class ServletLibrosLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibroRepository repositorio = new LibroRepositoryJDBC();
		List<Libro> listaLibros = repositorio.buscarTodos();
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<table border='1px solid black' style='text-center'>");
		for (Libro libro : listaLibros) {
			pw.println("<tr><td>" + libro.getIsbn() + "</td><td>" + libro.getTitulo() + "</td><td>" + libro.getAutor()
					+ "<td><a href='ServletLibroBorrar?isbn=" + libro.getIsbn() + "'>borrar</a></td></td>");
		}
		pw.println("</table>");
		pw.println("<a href='formularioLibro.html'>insertar</a>");
		pw.println("</body></html>");
	}

}
