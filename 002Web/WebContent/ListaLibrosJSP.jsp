<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>
<%@page import="com.arquitecturajavaJSP.repositorios.LibroRepository" %>
<%@page import="com.arquitecturajavaJSP.repositorios.jdbc.Libro_RepositoryJDBC" %>

<%
LibroRepository repositorio = new Libro_RepositoryJDBC();
List<Libro> listaLibros = repositorio.buscarTodosLibros();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table style='border-collapse: collapse;width: 100%;text-align: center;' border='2px solid black;'>
		<thead>
		<tr >
			<th>ISBN</th>
			<th>Titulo</th>
			<th>Autor</th>
		</tr>
		</thead>
		<tbody>
			<%for(Libro libro: listaLibros){ %>
            <tr>
            	<td><%=libro.getIsbn() %></td>
            	<td><%=libro.getTitulo() %></td>
            	<td><%=libro.getAutor() %></td>
            </tr>
            <% } %>
			<tr></tr>
		</tbody>
	</table>
	<a href="formularioLibro">Nuevo Libro</a>
</body>
</html>