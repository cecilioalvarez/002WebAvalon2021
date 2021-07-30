<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.arquitecturajava.negocio.Capitulo"%>
<%@page import="java.util.List"%>

<%
//Ya no accedo a la base de datos desde el jsp
List<Capitulo> listaCapitulo = (List<Capitulo>) request.getAttribute("capitulos");
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
				<th>Titulo</th>
				<th>Paginas</th>
				<th>Borrar</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Capitulo capitulo : listaCapitulo) {
			%>
			<tr>
				<td><%=capitulo.getTitulo()%></td>
				<td><%=capitulo.getPaginas()%></td>
				<td><a href="ServletControladorCapitulo?accion=borrar&titulo=<%=capitulo.getTitulo()%>">borrar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="ServletControladorCapitulo?accion=formularioinsertar&isbn=<%=listaCapitulo.get(0).getLibro().getIsbn()%>">nuevo capitulo</a>
</body>
</html>