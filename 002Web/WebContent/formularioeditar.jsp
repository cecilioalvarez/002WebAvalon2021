<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.arquitecturajava.negocio.Libro" %>
<%@page import="com.arquitecturajava.servicios.LibroService" %>
<%@page import="com.arquitecturajava.servicios.standard.LibroServiceStandard" %>
<%@page import="com.arquitecturajava.repositorios.jdbc.*" %>
<%
LibroService servicio=new LibroServiceStandard(new LibroRepositoryJDBC());
Libro libro=servicio.buscarUno(request.getParameter("isbn"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletActualizar" method="POST">
<p>ISBN: <input type="text" name="isbn" value="<%=libro.getIsbn() %>"/></p>
<p>Título: <input type="text" name="titulo" value="<%=libro.getTitulo() %>"/></p>
<p>Autor: <input type="text" name="autor" value="<%=libro.getAutor() %>"/></p>
<input type="submit" value="Guardar">
</form>
<a href="listaLibros.jsp">Volver</a>


</body>
</html>