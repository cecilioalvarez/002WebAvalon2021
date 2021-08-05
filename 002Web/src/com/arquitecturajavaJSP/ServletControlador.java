package com.arquitecturajavaJSP;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arquitecturajavaJSP.Spring.SpringConfigurador;
import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.repositorios.CapituloRepository;
import com.arquitecturajavaJSP.repositorios.LibroRepository;
import com.arquitecturajavaJSP.repositorios.jdbc.Capitulo_RepositoryJDBC;
import com.arquitecturajavaJSP.repositorios.jdbc.Libro_RepositoryJDBC;
import com.arquitecturajavaJSP.servicios.LibroService;
import com.arquitecturajavaJSP.servicios.standard.LibroServiceStandard;


@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	LibroService servicio;
	LibroRepository repositorioLibro;
	CapituloRepository repositorioCapitulo;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(SpringConfigurador.class);
		
		//repositorioLibro=contexto.getBean(Libro_RepositoryJDBC.class);
		//repositorioCapitulo=contexto.getBean(Capitulo_RepositoryJDBC.class);
		//servicio = new LibroServiceStandard(repositorioLibro,repositorioCapitulo);
		//Este es método para instanciar el servicio usando Spring
		servicio = contexto.getBean(LibroServiceStandard.class);
		
		RequestDispatcher despachador = null;
		if (request.getParameter("accion")==null) {
			//Controlador accede a la BD para obtener la lista
			List<Libro> listalibros = servicio.buscarTodosLibros();
			
			//Despachamos a una vista donde despachador puede adjuntar objetos
			despachador = request.getRequestDispatcher("ListaLibrosJSP.jsp");
			//lista de objetos libros que quiero enviar a la vista desde el controlador
			request.setAttribute("libros",listalibros);
			//Reenvía a la vista
			despachador.forward(request, response);
			
		}else if(request.getParameter("accion").equals("borrar")){
			Libro libro = servicio.buscarLibro(request.getParameter("isbn"));
			//En caso de BD sin configuración CASCADE
			/*List<Capitulo> listaCapitulos = servicio.getAllChaptersByBook(libro);
			for(Capitulo cap: listaCapitulos){
				servicio.removeChapter(cap);
			}*/
			servicio.removeBook(libro);
			response.sendRedirect("ServletControlador");
			
		}else if(request.getParameter("accion").equals("insertar")){
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			
			Libro libro = new Libro(isbn, autor, titulo);
			servicio.addBook(libro);
			
			//Controlador accede a la BD para obtener la lista
			List<Libro> listalibros = servicio.buscarTodosLibros();
			
			//Despachamos a una vista donde despachador puede adjuntar objetos
			despachador = request.getRequestDispatcher("ListaLibrosJSP.jsp");
			//lista de objetos libros que quiero enviar a la vista desde el controlador
			request.setAttribute("libros",listalibros);
			//Reenvía a la vista
			despachador.forward(request, response);
			
		}else if (request.getParameter("accion").equals("formularioInsertar")) {
			despachador = request.getRequestDispatcher("formularioLibroJSP.html");
			//Reenvía a la vista
			despachador.forward(request, response);
		}else if(request.getParameter("accion").equals("detalle")){
			String isbn = request.getParameter("isbn");
			
			Libro libro = servicio.buscarLibro(isbn);
			List<Capitulo> listaCapitulos = servicio.getAllChaptersByBook(libro);
			libro.setListacoCapitulos(listaCapitulos);
			//Despachamos a una vista donde despachador puede adjuntar objetos
			despachador = request.getRequestDispatcher("DetalleJSP.jsp");
			//lista de objetos libros que quiero enviar a la vista desde el controlador
			request.setAttribute("milibro",libro);
			request.setAttribute("misCapitulos",listaCapitulos);
			//Reenvía a la vista
			despachador.forward(request, response);
		}else if(request.getParameter("accion").equals("modificar")){
			
			Libro libro = new Libro(request.getParameter("isbn")
							, request.getParameter("autor")
							,request.getParameter("titulo"));
			System.out.println(libro);
			System.out.println(servicio.modifyBook(libro));
			
			response.sendRedirect("ServletControlador");
			
		}else if(request.getParameter("accion").equals("formularioModificar")){
			
			String isbn = request.getParameter("isbn");
			
			Libro libro = servicio.buscarLibro(isbn);
			
			//Despachamos a una vista donde despachador puede adjuntar objetos
			despachador = request.getRequestDispatcher("formularioEditarJSP.jsp");
			//lista de objetos libros que quiero enviar a la vista desde el controlador
			request.setAttribute("milibro",libro);
			//Reenvía a la vista
			despachador.forward(request, response);
		}else {
			//Controlador accede a la BD para obtener la lista
			List<Libro> listalibros = servicio.buscarTodosLibros();
			
			//Despachamos a una vista donde despachador puede adjuntar objetos
			despachador = request.getRequestDispatcher("ListaLibrosJSP.jsp");
			//lista de objetos libros que quiero enviar a la vista desde el controlador
			request.setAttribute("libros",listalibros);
			//Reenvía a la vista
			despachador.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
