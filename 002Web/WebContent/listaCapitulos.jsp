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
<title>Lista de capitulos</title>
</head>
<body>

<table>
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Páginas</th>
				
			</tr>
		</thead>
		<tbody>
			<%
			for (Capitulo capitulo : listaCapitulos) {
			%>

			<tr>
				<td><%=capitulo.getTitulo()%></td>
				<td><%=capitulo.getPaginas()%></td>
				
				
			</tr>
			<%
			}
			%>
		</tbody>

	</table>
	<!-- <a href="ServletControladorCapitulos?accion=formularioInsertar">nuevo capitulo</a> -->


</body>
</html>