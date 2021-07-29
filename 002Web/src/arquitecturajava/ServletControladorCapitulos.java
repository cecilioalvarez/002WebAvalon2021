package arquitecturajava;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Capitulo;
import negocio.Libro;
import repositorio.CapituloRepository;
import repositorio.jdbc.helper.CapituloRepositoryJDBC;
import repositorio.jdbc.helper.LibroRepositoryJDBC;
import repositorio.servicios.LibroService;
import repositorio.servicios.standard.LibroServiceStandard;

/**
 * Servlet implementation class ServletControladorCapitulo
 */
@WebServlet("/ServletControladorCapitulos")
public class ServletControladorCapitulos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LibroService servicio;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("accion") == null) {
			servicio = new LibroServiceStandard(new LibroRepositoryJDBC(), new CapituloRepositoryJDBC());
			List<Capitulo> capitulos = servicio.buscarTodosLosCapitulos();
			RequestDispatcher despachador = request.getRequestDispatcher("ListaCapitulosJSP.jsp");
			request.setAttribute("capitulos", capitulos);
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("borrar")) {
			servicio.borrarCapitulo(new Capitulo(request.getParameter("titulo")));
			response.sendRedirect("ServletControladorCapitulos");

		} else if (request.getParameter("accion").equals("formularioinsertar")) {
			RequestDispatcher despachador = request.getRequestDispatcher("formularioCapitulos.html");
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("insertar")) {

			Capitulo c = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")),
					new Libro(request.getParameter("isbn")));
			servicio.insertarCapitulo(c);
			System.out.println("entro a insertar capitulo");
			response.sendRedirect("ServletControladorCapitulos");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
