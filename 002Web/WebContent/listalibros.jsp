<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="com.arquitecturajava.negocio.Libro"%>
<%@page import="java.util.List"%>
<%@page import="com.arquitecturajava.repositorios.LibroRepository"%>
<%@page
	import="com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC"%>
<%
LibroRepository repositorio = new LibroRepositoryJDBC();
List<Libro> listaLibros = repositorio.buscarTodos();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border='8px solid black'>
		<thead>
			<tr>
				<th>ISBN</th>
				<th>TITULO</th>
				<th>AUTOR</th>
				<th>CAMPO BORRAR</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Libro libro : listaLibros) {
			%>
			<tr>
				<td><%=libro.getIsbn()%></td>
				<td><%=libro.getTitulo()%></td>
				<td><%=libro.getAutor()%></td>
				<td><a href="Servlet011_LibroBorrar?isbn=<%=libro.getIsbn()%>">borrar</a></td>
				<td><a href="detalle.jsp?isbn=<%=libro.getIsbn()%>">detalle</a></td>
				<td><a href="formularioeditar.jsp?isbn=<%=libro.getIsbn()%>">editar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="011_Formulario_Libro.html">nuevo libro</a>
</body>
</html>