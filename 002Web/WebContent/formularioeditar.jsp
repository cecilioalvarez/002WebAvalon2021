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
<title>Insert title here</title>
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