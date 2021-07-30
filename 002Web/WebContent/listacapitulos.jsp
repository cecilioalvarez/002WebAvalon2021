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
				<th>borrar</th>
				
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
					href="ServletControladorCapitulos?accion=borrar&titulo=<%=capitulo.getTitulo()%>&isbn=<%=request.getParameter("isbn")%>">borrar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="ServletControladorCapitulos?accion=formularioinsertar&isbn=<%=request.getParameter("isbn")%>">Nuevo capitulo</a>
</body>
</html>