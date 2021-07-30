<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<%@page import="com.arquitecturajava.negocio.Libro"%>

<%
List<Libro> listaLibros = (List<Libro>) request.getAttribute("libros");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>Lista libros</title>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ISBN</th>
				<th scope="col">Titulo</th>
				<th scope="col">Autor</th>
				<th scope="col">Acciones</th>
				<th scope="col">Ver Capitulos</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Libro libro : listaLibros) {
			%>

			<tr>
				<td><a href="ServletControlador?accion=detalle&isbn=<%=libro.getIsbn()%>"><%=libro.getIsbn()%></a></td>
				<td><a href="ServletControlador?accion=detalle&isbn=<%=libro.getIsbn()%>"><%=libro.getTitulo()%></a></td>
				<td><a href="ServletControlador?accion=detalle&isbn=<%=libro.getIsbn()%>"><%=libro.getAutor()%></a></td>
				<td><a
					href="ServletControlador?accion=borrar&isbn=<%=libro.getIsbn()%>">Borrar</a>
				<a
					href="ServletControlador?accion=editar&isbn=<%=libro.getIsbn()%>">Editar</a></td>
				
				<td><a href="ServletControlador?accion=capituloslibros&isbn=<%=libro.getIsbn()%>">Capitulos</a></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>
	<a href="ServletControlador?accion=formularioInsertar">Agregar libro</a>

</body>
</html>