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
	<form action="ServletActualizar" method="post">
		<p>
			ISBN:<input type="text" name="isbn" value="<%=libro.getIsbn()%>" />
		</p>
		<p>
			TITULO:<input type="text" name="titulo" value="<%=libro.getTitulo()%>" />
		</p>
		<p>
			AUTOR:<input type="text" name="autor" value="<%=libro.getAutor()%>" />
		</p>
		<input type="submit" value="actualizar"/>
	</form>
</body>
</html>