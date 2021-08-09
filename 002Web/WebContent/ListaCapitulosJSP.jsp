<%@page import="repositorio.jdbc.helper.LibroRepositoryJDBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="negocio.Capitulo"%>
<%@page import="repositorio.jdbc.*"%>
<%@page import="repositorio.servicios.LibroService"%>
<%@page import="repositorio.servicios.standard.*"%>
<%@page import="java.util.List"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado capitulos</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>titulo</th>
				<th>paginas</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cap" items="${capitulos}">
				<tr>

					<td>${cap.titulo}</td>
					<td>${cap.paginas}</td>
					<td><a
						href="ServletControladorCapitulos?accion=borrar&titulo=${cap.titulo}
					&isbn=<%=request.getParameter("isbn")%>">borrar</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a
		href="ServletControladorCapitulos?accion=formularioinsertar&isbn=${isbn}">Nuevo
		capitulo</a>
		<a href="ServletControlador">volver</a>
</body>
</html>