package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import negocio.Libro;
import repositorio.jdbc.helper.CapituloRepositoryJDBC;
import repositorio.jdbc.helper.LibroRepositoryJDBC;
import repositorio.servicios.LibroService;
import repositorio.servicios.standard.LibroServiceStandard;

/**
 * Servlet implementation class ServletAjax2
 */
@WebServlet("/ServletAjax2")
public class ServletAjax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LibroService servicio;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		servicio = new LibroServiceStandard(new LibroRepositoryJDBC(), new CapituloRepositoryJDBC());
		List<Libro> listaLibros = servicio.buscarTodos();
		// TODO Auto-generated method stub
		//Libro libro = new Libro("la", "java", "web");
		//Libro libro2 = new Libro("la222", "jav222a", "w22eb");
		ObjectMapper mapeador = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		pw.println(mapeador.writeValueAsString(listaLibros));
	}



}
