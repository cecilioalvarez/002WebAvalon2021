<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="com.arquitecturajava.negocio.Libro"%>
<%@page import="com.arquitecturajava.repositorios.LibroRepository"%>
<%@page
	import="com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC"%>
<%
LibroRepository repositorio = new LibroRepositoryJDBC();
Libro libro = repositorio.buscarUno(request.getParameter("isbn"));
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		ISBN:<%=libro.getIsbn()%>
	</p>
	<p>
		TITULO:<%=libro.getTitulo()%>
	</p>
	<p>
		AUTOR:<%=libro.getAutor()%>
	</p>
</body>
</html>