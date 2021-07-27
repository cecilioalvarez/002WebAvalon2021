<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="negocio.Libro" %>
<%@page import="repositorio.LibroRepository" %>
<%@page import="repositorio.jdbc.helper.LibroRepositoryJDBC" %>
<%@page import="java.util.List" %>
<%

LibroRepository repositorio = new LibroRepositoryJDBC();
List<Libro> listaLibros = repositorio.buscarTodos();



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
			<td><a href="ServletLibroBorrar?isbn=<%=libro.getIsbn()%>">borrar</a></td>
			<td><a href="detalle.jsp?isbn=<%=libro.getIsbn()%>">detalle</a></td>
			<td><a href="formularioEditar.jsp?isbn=<%=libro.getIsbn()%>">editar</a></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<a href="formularioLibro.html">Nuevo libro</a>
</body>
</html>