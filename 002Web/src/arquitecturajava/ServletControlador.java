package arquitecturajava;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import arquitecturaspring.SpringConfigurador;
import negocio.Capitulo;
import negocio.Libro;
import repositorio.servicios.LibroService;
import repositorio.servicios.standard.LibroServiceStandard;

/**
 * Servlet implementation class ServletControlador
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LibroService servicio;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//INSTANCIA DE LOS OBJETOS IMPORTANTES
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(SpringConfigurador.class);
		
		//al instanciar el libroservice, verá que tiene dos dependencias (librorepository y capitulorepository)
		servicio = contexto.getBean(LibroService.class);


		RequestDispatcher despachador = null;
		if (request.getParameter("accion") == null) {

			List<Libro> listaLibros = servicio.buscarTodos();
			// aqui se rellena la coleccion del request para la vista
			request.setAttribute("libros", listaLibros);
			despachador = request.getRequestDispatcher("ListaLibrosJSP.jsp");
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("borrar")) {

			servicio.borrar(new Libro(request.getParameter("isbn")));
			response.sendRedirect("ServletControlador");

		} else if (request.getParameter("accion").equals("detalle")) {

			Libro libro = servicio.buscarUno(request.getParameter("isbn"));

			request.setAttribute("libro", libro);
			despachador = request.getRequestDispatcher("detalle.jsp");
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("insertar")) {

			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");

			Libro libro = new Libro(isbn, titulo, autor);
			servicio.insertar(libro);

			List<Libro> listaLibros = servicio.buscarTodos();
			request.setAttribute("libros", listaLibros);
			response.sendRedirect("ServletControlador");

		}else if (request.getParameter("accion").equals("insertar2")) {

			String isbn = request.getParameter("isbn1");
			String titulo = request.getParameter("titulo1");
			String autor = request.getParameter("autor1");
			String isbn2 = request.getParameter("isbn2");
			String titulo2 = request.getParameter("titulo2");
			String autor2 = request.getParameter("autor2");


			Libro libro = new Libro(isbn, titulo, autor);
			Libro libro2 = new Libro(isbn2, titulo2, autor2);
			servicio.insertarVariosLibros(libro, libro2);

			//List<Libro> listaLibros = servicio.buscarTodos();
			//request.setAttribute("libros", listaLibros);
			response.sendRedirect("ServletControlador");

		} else if (request.getParameter("accion").equals("actualizar")) {

			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");

			Libro libro = new Libro(isbn, titulo, autor);
			servicio.actualizar(libro);
			System.out.println("entro por actualizar");
			response.sendRedirect("ServletControlador");

		} else if (request.getParameter("accion").equals("formularioEditar")) {

			String isbn = request.getParameter("isbn");
			Libro libro = servicio.buscarUno(isbn);
			request.setAttribute("libro", libro);
			despachador = request.getRequestDispatcher("formularioEditar.jsp");
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("capituloslibros")) {

			String isbn = request.getParameter("isbn");
			List<Capitulo> capitulos = servicio.buscarTodosLosCapitulos(new Libro(isbn));
			request.setAttribute("capitulos", capitulos);
			request.setAttribute("isbn", isbn);
			despachador = request.getRequestDispatcher("ListaCapitulosJSP.jsp");
			despachador.forward(request, response);
			
		}else if (request.getParameter("accion").equals("formularioInsertarVarios")) {

			despachador = request.getRequestDispatcher("formularioLibros.html");
			despachador.forward(request, response);
			
		}  else {

			despachador = request.getRequestDispatcher("formularioLibro.html");
			despachador.forward(request, response);
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
