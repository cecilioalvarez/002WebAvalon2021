<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.arquitecturajava.negocio.Libro"%>

<%@page import="com.arquitecturajava.servicios.LibroService"%>
<%@page
	import="com.arquitecturajava.servicios.standard.LibroServiceStandard"%>
<%@page
	import="com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC"%>
<%
LibroService servicio = new LibroServiceStandard(new LibroRepositoryJDBC());
Libro libro = servicio.buscarUno(request.getParameter("isbn"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		Isbn:<%=libro.getIsbn()%>
	</p>
	<p>
		Titulo:<%=libro.getTitulo()%>
	</p>
	<p>
		Autor:<%=libro.getAutor()%>
	</p>
</body>
</html>