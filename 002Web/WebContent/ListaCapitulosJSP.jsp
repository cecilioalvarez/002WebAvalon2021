<%@page import="repositorio.jdbc.helper.LibroRepositoryJDBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="negocio.Capitulo" %>
<%@page import="repositorio.jdbc.*" %>
<%@page import="repositorio.servicios.LibroService" %>
<%@page import="repositorio.servicios.standard.*" %>
<%@page import="java.util.List" %>
<%

/*LibroService repositorio = new LibroServiceStandard(new LibroRepositoryJDBC());
List<Libro> listaLibros = repositorio.buscarTodos();*/
List<Capitulo> listaCapitulos = (List<Capitulo>)request.getAttribute("capitulos");

%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado capitulos</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>titulo</th>
				<th>paginas</th>
			</tr>
		</thead>
		<tbody>
		<%for(Capitulo cap: listaCapitulos)
			{%>
			<tr>

			<td><%=cap.getTitulo() %></td>
			<td><%=cap.getPaginas() %></td>
				<td><a href="ServletControlador?accion=borrar&isbn=<%=cap.getTitulo()%>">borrar</a></td>

			</tr>
			<%} %>
		</tbody>
	</table>
<a href="ServletControladorCapitulos?accion=formularioinsertar">Nuevo capitulo</a>
</body>
</html>