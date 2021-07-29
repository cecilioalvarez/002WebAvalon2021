<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<%@page import="com.arquitecturajava.negocio.Libro"%>


<%
List<Libro> listaLibros = (List<Libro>) request.getAttribute("libros");
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
			<%
			for (Libro libro : listaLibros) {
			%>

			<tr>
				<td><%=libro.getIsbn()%></td>
				<td><%=libro.getTitulo()%></td>
				<td><%=libro.getAutor()%></td>
				<td><a
					href="ServletControlador?accion=borrar&isbn=<%=libro.getIsbn()%>">Borrar</a></td>
				<td><a
					href="ServletControlador?accion=detalle&isbn=<%=libro.getIsbn()%>">Detalle</a></td>
				<td><a href="ServletControlador?accion=formularioeditar&isbn=<%=libro.getIsbn()%>">Editar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>
	<a href="ServletControlador?accion=formularioInsertar">nuevo libro</a>

</body>
</html>