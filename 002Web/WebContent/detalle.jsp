<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.arquitecturajava.negocio.Libro" %>
<%@page import="com.arquitecturajava.repositorios.LibroRepository" %>
<%@page import="com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC" %>
<%
LibroRepository repositorio=new LibroRepositoryJDBC();
Libro libro=repositorio.buscarUno(request.getParameter("isbn"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>ISBN: <%=libro.getIsbn() %></p>
<p>Título: <%=libro.getTitulo() %></p>
<p>Autor: <%=libro.getAutor() %></p>
<a href="listaLibros.jsp">Volver</a>


</body>
</html>