<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="com.arquitecturajava.negocio.Capitulo"%>
    <%
List<Capitulo> listaCapitulos = (List<Capitulo>) request.getAttribute("capitulos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>Lista de capitulos</title>
</head>
<body>

<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Titulo</th>
				<th scope="col">Páginas</th>
				
			</tr>
		</thead>
		<tbody>
			<%
			for (Capitulo capitulo : listaCapitulos) {
			%>

			<tr>
				<td><%=capitulo.getTitulo()%></td>
				<td><%=capitulo.getPaginas()%></td> 
				<td><a
					href="ServletControladorCapitulos?accion=borrar&titulo=<%=capitulo.getTitulo()%>&isbn=<%=request.getParameter("isbn")%>">Borrar</a></td>
				</tr>
			<%
			}
			%>
		</tbody>

	</table>
	
	<p><a href="ServletControladorCapitulos?accion=formularioInsertar&isbn=<%=request.getParameter("isbn")%>">nuevo capitulo</a></p>
	
	
	<p><a href="ServletControlador">Listado libros</a></p> 

</body>
</html>