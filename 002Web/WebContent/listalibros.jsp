<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="com.arquitecturajava.negocio.Libro"%>
<%@page import="java.util.List"%>

<%
// ya no accedo a la base de datos desde el jsp
List<Libro> listaLibros = (List<Libro>) request.getAttribute("libros");
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
				<th>CAMPO DETALLE</th>
				<th>CAMPO EDITAR</th>
				<th>VER LOS CAPITULOS DEL LIBRO</th>
			</tr>
		</thead>
		<tbody>
			<%for (Libro libro : listaLibros) {%>
			<tr>
				<td><%=libro.getIsbn()%></td>
				<td><%=libro.getTitulo()%></td>
				<td><%=libro.getAutor()%></td>
				<td><a href="ServletControlador?accion=borrar&isbn=<%=libro.getIsbn()%>">borrar</a></td>
				<td><a href="ServletControlador?accion=detalle&isbn=<%=libro.getIsbn()%>">detalle</a></td>
				<td><a href="ServletControlador?accion=formularioeditar&isbn=<%=libro.getIsbn()%>">editar</a></td>
				<td><a href="ServletControlador?accion=capituloslibros&isbn=<%=libro.getIsbn()%>">ver capitulos</a></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<a href="ServletControlador?accion=fomularioInsertar">INSERTAR NUEVO LIBRO</a>
</body>
</html>