<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.arquitecturajava.negocio.Libro"%>
<%@page import="java.util.List"%>

<%
//Ya no accedo a la base de datos desde el jsp
List<Libro> listaLibros = (List<Libro>) request.getAttribute("libros");
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
			<%
			for (Libro libro : listaLibros) {
			%>
			<tr>
				<td><%=libro.getIsbn()%></td>
				<td><%=libro.getTitulo()%></td>
				<td><%=libro.getAutor()%></td>
				<td><a href="ServletControlador?accion=borrar&isbn=<%=libro.getIsbn()%>">borrar</a></td>
				<td><a href="detalle.jsp?isbn=<%=libro.getIsbn()%>">detalle</a></td>
				<td><a href="formularioeditar.jsp?isbn=<%=libro.getIsbn()%>">editar</a></td>
				
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="ServletControlador?accion=formularioInsertar">nuevo libro</a>
</body>
</html>