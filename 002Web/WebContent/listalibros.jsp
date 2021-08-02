<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='8px solid black'>
		<thead>
			<tr>
				<th>ISBN</th>
				<th>TITULO</th>
				<th>AUTOR</th>
				<th>CAMPO BORRAR</th>
				<th>CAMPO DETALLE</th>
				<th>CAMPO EDITAR</th>
				<th>VER LOS CAPITULOS DEL LIBRO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="libro" items="${libros}">
				<tr>
					<td>${libro.isbn}</td>
					<td>${fn:toUpperCase(libro.titulo)}</td>
					<td>${libro.autor}</td>
					<td><a
						href="ServletControlador?accion=borrar&isbn=${libro.isbn}">borrar</a></td>
					<td><a
						href="ServletControlador?accion=detalle&isbn=${libro.isbn}">detalle</a></td>
					<td><a
						href="ServletControlador?accion=formularioeditar&isbn=${libro.isbn}">editar</a></td>
					<td><a
						href="ServletControlador?accion=capituloslibros&isbn=${libro.isbn}">ver	capitulos</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="ServletControlador?accion=formularioInsertar">INSERTAR NUEVO LIBRO</a>
</body>
</html>