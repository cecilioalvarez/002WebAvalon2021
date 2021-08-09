<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
						href="ServletControlador?accion=formularioEditar&isbn=${libro.isbn}">editar</a></td>
					<td><a
						href="ServletControlador?accion=capituloslibros&isbn=${libro.isbn}">ver
							capitulos</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="ServletControlador?accion=formularioInsertar">Nuevo libro</a>
	<a href="ServletControlador?accion=formularioInsertarVarios">Nuevos libros</a>
</body>
</html>