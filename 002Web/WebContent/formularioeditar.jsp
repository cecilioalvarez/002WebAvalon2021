<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.arquitecturajava.negocio.Libro"%>

<%
Libro libro=(Libro)request.getAttribute("libro");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>Editar Capítulo</title>
</head>
<body>
	<form action="ServletControlador" method="POST">
		<p>
			ISBN: <input type="text" name="isbn" value="<%=libro.getIsbn()%>" />
		</p>
		<p>
			Título: <input type="text" name="titulo"
				value="<%=libro.getTitulo()%>" />
		</p>
		<p>
			Autor: <input type="text" name="autor" value="<%=libro.getAutor()%>" />
		</p>
		<input type="hidden" name="accion" value="actualizar">
		<input type="submit" value="Guardar">
	</form>
	<a href="ServletControlador">Volver</a>


</body>
</html>