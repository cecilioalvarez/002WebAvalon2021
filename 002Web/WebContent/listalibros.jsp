<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  import="com.arquitecturajava.negocio.Libro" %>
<%@page  import="java.util.List" %>
<%@page  import="com.arquitecturajava.repositorios.LibroRepository" %>
<%@page  import="com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC" %>
<%
LibroRepository repositorio= new LibroRepositoryJDBC();
List<Libro> listaLibros=repositorio.buscarTodos();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>isbn</th>
				<th>titulo</th>
				<th>autor</th>
			</tr>
		</thead>
		<tbody>
		<%for(Libro libro: listaLibros) {%>
		<tr>
			<td><%=libro.getIsbn()%></td>
			<td><%=libro.getTitulo()%></td>
			<td><%=libro.getAutor()%></td>
		
		</tr>
		<% } %>
		</tbody>
	</table>
</body>
</html>