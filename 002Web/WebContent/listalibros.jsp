<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


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
				<td><c:out value="${libro.isbn}"/></td>
				<td><c:out value="${libro.titulo}"/></td>
				<td><c:out value="${libro.autor}"/></td>
				<td><a
					href="ServletControlador?accion=borrar&isbn=<c:out value="${libro.isbn}"/>">borrar</a></td>
				<td><a
					href="ServletControlador?accion=detalle&isbn=<c:out value="${libro.isbn}"/>">detalle</a></td>
				<td><a href="ServletControlador?accion=formularioeditar&isbn=<c:out value="${libro.isbn}"/>">editar</a></td>
				<td><a href="ServletControlador?accion=capituloslibros&isbn=<c:out value="${libro.isbn}"/>">ver capitulos</a></td>
		
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="ServletControlador?accion=formularioInsertar">Nuevo libro</a>
</body>
</html>