<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.arquitecturajava.negocio.Capitulo"%>
<%@page import="java.util.List"%>

<%
// ya no accedo a la base de datos desde el jsp
List<Capitulo> listaCapitulos = (List<Capitulo>) request.getAttribute("capitulos");
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
				<th>titulo</th>
				<th>paginas</th>
				
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
	<a href="ServletControlador?accion=formularioInsertar">Nuevo capitulo</a>
</body>
</html>