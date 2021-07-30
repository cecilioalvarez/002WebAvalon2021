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
		
		servicio = new LibroServiceStandard(new LibroRepositoryJDBC(), new CapituloRepositoryJDBC());

		if (request.getParameter("accion") == null) {
			
			List<Capitulo> capitulos = servicio.buscarTodosLosCapitulos();
			RequestDispatcher despachador = request.getRequestDispatcher("ListaCapitulosJSP.jsp");
			request.setAttribute("capitulos", capitulos);
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("borrar")) {
	
			servicio.borrarCapitulo(new Capitulo(request.getParameter("titulo")));
			String isbn= request.getParameter("isbn");
			response.sendRedirect("ServletControlador?accion=capituloslibros&isbn="+isbn);

		} else if (request.getParameter("accion").equals("formularioinsertar")) {
			RequestDispatcher despachador = request.getRequestDispatcher("formularioCapitulos.jsp");
			String isbn = request.getParameter("isbn");
			request.setAttribute("isbn", isbn);
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("insertar")) {

			Capitulo c = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")),
					new Libro(request.getParameter("isbn")));
			servicio.insertarCapitulo(c);
			String isbn= request.getParameter("isbn");
			System.out.println("entro a insertar capitulo");
			response.sendRedirect("ServletControlador?accion=capituloslibros&isbn="+isbn);

		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
