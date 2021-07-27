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
<style type="text/css">
	a {
		text-decoration:none;
	}
</style>
</head>
<body>
	<table style="border-collapse: collapse;width: 100%;text-align: center;" border="2px solid black;">
		<thead>
		<tr style="background-color: #E1B933;color: white;" >
			<th>ISBN</th>
			<th>Titulo</th>
			<th>Autor</th>
			<th colspan="3">Acciones</th>
			<!-- <th>Borrar</th>
			<th>Detalle</th>
			<th>Modificar</th> -->
		</tr>
		</thead>
		<tbody>
			<%for(Libro libro: listaLibros){ %>
	            <tr>
	            	<td><%=libro.getIsbn() %></td>
	            	<td><%=libro.getTitulo() %></td>
	            	<td><%=libro.getAutor() %></td>
	            	<td><a href="ServletLibrosRemoveJSP?isbn=<%=libro.getIsbn()%>" style="color: red">Borrar</a></td>
	            	<td><a href="DetalleJSP.jsp?isbn=<%=libro.getIsbn()%>" style="color: purple">Detalle</a></td>
	            	<td><a href="formularioEditarJSP.jsp?isbn=<%=libro.getIsbn()%>" style="color: blue">Modificar</a></td>
	            </tr>
            <% } %>
			<tr></tr>
		</tbody>
	</table>
	<a href="formularioLibroJSP.html" style="color: green">Nuevo Libro</a>
</body>
</html>