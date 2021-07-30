package com.arquitecturajavaJSP;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.repositorios.jdbc.Capitulo_RepositoryJDBC;
import com.arquitecturajavaJSP.repositorios.jdbc.Libro_RepositoryJDBC;
import com.arquitecturajavaJSP.servicios.LibroService;
import com.arquitecturajavaJSP.servicios.standard.LibroServiceStandard;


@WebServlet("/ServletControladorCapitulo")
public class ServletControladorCapitulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	LibroService servicio;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servicio = new LibroServiceStandard(new Libro_RepositoryJDBC(),new Capitulo_RepositoryJDBC());
		RequestDispatcher despachador = null;
		if (request.getParameter("accion")==null) {
			//Controlador accede a la BD para obtener la lista
			List<Capitulo> listaCapitulos = servicio.getAllChapters();
			
			//Despachamos a una vista donde despachador puede adjuntar objetos
			despachador = request.getRequestDispatcher("ListaCapitulosJSP.jsp");
			//lista de objetos libros que quiero enviar a la vista desde el controlador
			request.setAttribute("capitulos",listaCapitulos);
			//Reenvía a la vista
			despachador.forward(request, response);
			
		}else if (request.getParameter("accion").equals("formularioInsertar")) {
			despachador = request.getRequestDispatcher("formularioInsertCapitulosJSP.jsp");
			String isbn = request.getParameter("isbn");
			System.out.println(isbn);
			request.setAttribute("miIsbn",isbn);
			//Reenvía a la vista
			despachador.forward(request, response);
		}else if(request.getParameter("accion").equals("insertar")){
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			int paginas = Integer.parseInt(request.getParameter("paginas"));
			
			
			Capitulo capitulo = new Capitulo(titulo, paginas, new Libro(isbn));
			servicio.addChapter(capitulo);
			
			response.sendRedirect("ServletControlador");
			
		}else if(request.getParameter("accion").equals("borrar")){
			String isbnLibro = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			servicio.removeChapter(new Capitulo(titulo, new Libro(isbnLibro)));
			response.sendRedirect("ServletControlador");
			
		}else if(request.getParameter("accion").equals("detalle")){
			String title = request.getParameter("titulo");
			String isbn = request.getParameter("isbn");
			
			Capitulo chapter = servicio.getOneChapter(new Capitulo(title,new Libro(isbn)));
			
			//Despachamos a una vista donde despachador puede adjuntar objetos
			despachador = request.getRequestDispatcher("DetalleCapitulosJSP.jsp");
			//lista de objetos libros que quiero enviar a la vista desde el controlador
			request.setAttribute("miCapitulo",chapter);
			//Reenvía a la vista
			despachador.forward(request, response);
		}else if(request.getParameter("accion").equals("formularioModificar")){
			
			String titulo = request.getParameter("titulo");
			String isbn = request.getParameter("isbn");
			
			Capitulo capitulo = servicio.getOneChapter(new Capitulo(titulo,new Libro(isbn)));
			//System.out.println("Paso por formulario modificar: "+capitulo.toString());
			//Despachamos a una vista donde despachador puede adjuntar objetos
			despachador = request.getRequestDispatcher("formularioEditarCapituloJSP.jsp");
			//lista de objetos libros que quiero enviar a la vista desde el controlador
			request.setAttribute("miCapitulo",capitulo);
			//Reenvía a la vista
			despachador.forward(request, response);
		}else if(request.getParameter("accion").equals("modificar")){
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			int paginas = Integer.parseInt(request.getParameter("paginas"));
			
			Capitulo capitulo = new Capitulo(titulo, paginas, new Libro(isbn));
			
			servicio.modifyChapter(capitulo);
			response.sendRedirect("ServletControlador");
			
		}else {
			//Controlador accede a la BD para obtener la lista
			List<Capitulo> listaCapitulos = servicio.getAllChapters();
			
			//Despachamos a una vista donde despachador puede adjuntar objetos
			despachador = request.getRequestDispatcher("ListaCapitulosJSP.jsp");
			//lista de objetos libros que quiero enviar a la vista desde el controlador
			request.setAttribute("capitulos",listaCapitulos);
			//Reenvía a la vista
			despachador.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
