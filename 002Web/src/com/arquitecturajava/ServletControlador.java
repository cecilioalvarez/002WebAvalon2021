package com.arquitecturajava;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.CapituloRepositoryJDBC;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.standard.LibroServiceStandard;
import com.arquitecturajavaspring.SpringConfigurador;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LibroService servicio;
	LibroRepository repositorioLibro;
	CapituloRepository repositorioCapitulo;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AnnotationConfigApplicationContext contexto= new AnnotationConfigApplicationContext(SpringConfigurador.class);
		
		//servicio=contexto.getBean(LibroServiceStandard.class);
		//repositorioLibro=contexto.getBean(LibroRepositoryJDBC.class);
		//repositorioCapitulo=contexto.getBean(CapituloRepositoryJDBC.class);

		servicio = contexto.getBean(LibroServiceStandard.class);
		
		RequestDispatcher despachador;
		if (request.getParameter("accion") == null) {

			List<Libro> listaLibros = servicio.buscarTodos();
			request.setAttribute("libros", listaLibros);
			despachador = request.getRequestDispatcher("listaLibros.jsp");
			despachador.forward(request, response);

		} else if (request.getParameter("accion").equals("borrar")) {
			
			servicio.borrar(new Libro(request.getParameter("isbn")));
			response.sendRedirect("ServletControlador");
			
		} else if (request.getParameter("accion").equals("insertar")) {
			
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			Libro libro = new Libro(isbn, titulo, autor);
			servicio.insertar(libro);
			response.sendRedirect("ServletControlador");
			
		}else if (request.getParameter("accion").equals("actualizar")) {
				
				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				Libro libro = new Libro(isbn, titulo, autor);
				servicio.actualizar(libro);
				response.sendRedirect("ServletControlador");
				
		}else if (request.getParameter("accion").equals("formularioeditar")) {
			
			Libro l=servicio.buscarUno(request.getParameter("isbn"));
			request.setAttribute("libro", l);
			despachador=request.getRequestDispatcher("formularioeditarlibro.jsp");
			despachador.forward(request, response);
		
	
		}else if (request.getParameter("accion").equals("detalle")) {
			
			Libro l=servicio.buscarUno(request.getParameter("isbn"));
			request.setAttribute("libro", l);
			despachador=request.getRequestDispatcher("detalle.jsp");
			despachador.forward(request, response);
			
		}else if(request.getParameter("accion").equals("capituloslibros")) {
			
			String isbn=request.getParameter("isbn");
			List<Capitulo> capitulos=servicio.buscarTodosCapitulos(new Libro(isbn));
			request.setAttribute("capitulos", capitulos);
			
			despachador=request.getRequestDispatcher("listaCapitulos.jsp");
			despachador.forward(request, response);
		}else if(request.getParameter("accion").equals("editar")){
			
			Libro l=servicio.buscarUno(request.getParameter("isbn"));
			request.setAttribute("libro", l);
			despachador=request.getRequestDispatcher("formularioeditarlibro.jsp");
			despachador.forward(request, response);
			
		}else {
			
			despachador=request.getRequestDispatcher("formularioLibro.jsp");
			despachador.forward(request, response);
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO Auto-generated method stub
		doGet(request,response);

	}

}
