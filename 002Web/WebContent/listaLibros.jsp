<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

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
			<c:forEach var="libro" items="${libros}">

			<tr>
				<td><a href="ServletControlador?accion=detalle&isbn=${libro.isbn}">${libro.isbn}</a></td>
				<td><a href="ServletControlador?accion=detalle&isbn=${libro.isbn}">${fn:toUpperCase(libro.titulo)}</a></td>
				<td><a href="ServletControlador?accion=detalle&isbn=${libro.isbn}">${libro.autor}</a></td>
				<td><a
					href="ServletControlador?accion=borrar&isbn=${libro.isbn}">Borrar</a>
				<a
					href="ServletControlador?accion=editar&isbn=${libro.isbn}">Editar</a></td>
				
				<td><a href="ServletControlador?accion=capituloslibros&isbn=${libro.isbn}">Capitulos</a></td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="ServletControlador?accion=formularioInsertar">Agregar libro</a>
	<a href="ServletControlador?accion=formularioInsertarVarios">Agregar nuevos libros</a>

</body>
</html>