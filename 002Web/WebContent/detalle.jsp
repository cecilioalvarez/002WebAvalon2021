<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="negocio.Libro"%>
<%@page import="repositorio.LibroRepository"%>
<%@page import="repositorio.jdbc.helper.LibroRepositoryJDBC"%>

<%
LibroRepository repositorio = new LibroRepositoryJDBC();
Libro libro = repositorio.buscarUno(request.getParameter("isbn"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle</title>
</head>
<body>
	<p>
		Isbn:
		<%=libro.getIsbn()%>
	</p>
	<p>
		Titulo:
		<%=libro.getTitulo()%>
	</p>
	<p>
		Autor:
		<%=libro.getAutor()%>
	</p>

</body>
</html>