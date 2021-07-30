<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
			ISBN: <input type="text" name="isbn" value="${libro.isbn}" />
		</p>
		<p>
			Título: <input type="text" name="titulo"
				value="${libro.titulo}" />
		</p>
		<p>
			Autor: <input type="text" name="autor" value="${libro.autor}" />
		</p>
		<input type="hidden" name="accion" value="actualizar">
		<input type="submit" value="Guardar">
	</form>
	<a href="ServletControlador">Volver</a>


</body>
</html>