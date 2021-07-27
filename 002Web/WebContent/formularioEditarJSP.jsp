<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>
<%@page import="com.arquitecturajavaJSP.repositorios.LibroRepository" %>
<%@page import="com.arquitecturajavaJSP.repositorios.jdbc.Libro_RepositoryJDBC" %>

<%
LibroRepository repositorio = new Libro_RepositoryJDBC();
Libro libro = repositorio.buscarLibro(request.getParameter("isbn"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletUpdateJSP" method="POST">
	<p>
		ISBN: <input type="text" name="isbn" value="<%=libro.getIsbn()%>"/>
	</p>
	<p>
		Título: <input type="text" name="titulo" value="<%=libro.getTitulo()%>"/>
	</p>
	<p>
		Autor: <input type="text" name="autor" value="<%=libro.getAutor()%>"/>
	</p>
	<input style="background-color: green;color: white;border-color: green" type="submit" value="Guardar Cambios"/>
</form>
</body>
</html>