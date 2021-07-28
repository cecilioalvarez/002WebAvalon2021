<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>

<%
//Ya no accedo a DB desde jsp, sino al ServletControlador
List<Libro> listaLibros = (List<Libro>) request.getAttribute("libros");
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
	            	<td><a href="ServletControlador?accion=borrar&isbn=<%=libro.getIsbn()%>" style="color: red">Borrar</a></td>
	            	<td><a href="ServletControlador?accion=detalle&isbn=<%=libro.getIsbn()%>" style="color: purple">Detalle</a></td>
	            	<td><a href="ServletControlador?accion=formularioModificar&isbn=<%=libro.getIsbn()%>" style="color: blue">Modificar</a></td>
	            </tr>
            <% } %>
			<tr></tr>
		</tbody>
	</table>
	<a href="ServletControlador?accion=formularioInsertar" style="color: green">Nuevo Libro</a>
</body>
</html>