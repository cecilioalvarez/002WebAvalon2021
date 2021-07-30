<%@page import="repositorio.jdbc.helper.LibroRepositoryJDBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="negocio.Libro" %>
<%@page import="repositorio.jdbc.*" %>
<%@page import="repositorio.servicios.LibroService" %>
<%@page import="repositorio.servicios.standard.*" %>
<%@page import="java.util.List" %>
<%

/*LibroService repositorio = new LibroServiceStandard(new LibroRepositoryJDBC());
List<Libro> listaLibros = repositorio.buscarTodos();*/
List<Libro> listaLibros = (List<Libro>)request.getAttribute("libros");



%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado libros</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>isbn</th>
				<th>titulo</th>
				<th>autor</th>
			</tr>
		</thead>
		<tbody>
		<%for(Libro libro: listaLibros)
			{%>
			<tr>
			<td><%=libro.getIsbn() %></td>
			<td><%=libro.getTitulo() %></td>
			<td><%=libro.getAutor() %></td>
			<td><a href="ServletControlador?accion=borrar&isbn=<%=libro.getIsbn()%>">borrar</a></td>
			<td><a href="ServletControlador?accion=detalle&isbn=<%=libro.getIsbn()%>">detalle</a></td>
			<td><a href="ServletControlador?accion=formularioEditar&isbn=<%=libro.getIsbn()%>">editar</a></td>
			<td><a href="ServletControlador?accion=capituloslibros&isbn=<%=libro.getIsbn()%>">ver capitulos</a></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<a href="ServletControlador?accion=formularioInsertar">Nuevo libro</a>
</body>
</html>