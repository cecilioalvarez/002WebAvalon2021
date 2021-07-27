<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page  import="java.util.List" %>

<%@page import="com.arquitecturajava.negocio.Libro" %>
<%@page import="com.arquitecturajava.servicios.LibroService" %>
<%@page import="com.arquitecturajava.servicios.standard.LibroServiceStandard" %>
<%@page import="com.arquitecturajava.repositorios.jdbc.*" %>
<%
LibroService repositorio=new LibroServiceStandard(new LibroRepositoryJDBC());
List<Libro> listaLibros=repositorio.buscarTodos();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Titulo</th>
				<th>Autor</th>
			</tr>
		</thead>
		<tbody>
		<%for(Libro libro :listaLibros) {%>
		
		<tr>
			<td><%=libro.getIsbn()%></td>
			<td><%=libro.getTitulo()%></td>
			<td><%=libro.getAutor()%></td>
			<td><a href="ServletLibroBorrar?isbn=<%=libro.getIsbn()%>">Borrar</a></td>
			<td><a href="detalle.jsp?isbn=<%=libro.getIsbn()%>">Detalle</a></td>
			<td><a href="formularioeditar.jsp?isbn=<%=libro.getIsbn()%>">Editar</a></td>
		</tr>
		<%} %>
		</tbody>

	</table>
	<a href="formularioLibro.html">nuevo libro</a>

</body>
</html>