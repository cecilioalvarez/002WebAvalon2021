<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<table border='8px solid black'>
		<thead>
			<tr>
				<th>TITULO</th>
				<th>PAGINAS</th>
				<th>BORRAR</th>
			</tr>
		</thead>
		<tbody>
			<%for (Capitulo capitulo : listaCapitulos) {%>
			<tr>
				<td><%=capitulo.getTitulo()%></td>
				<td><%=capitulo.getPaginas()%></td>
				<td>
				<a href="ServletControladorCapitulos?accion=borrar&titulo=<%=capitulo.getTitulo()%>&isbn=<%=request.getParameter("isbn")%>">borrar</a>
				</td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<p>
	<a href="ServletControladorCapitulos?accion=formularioinsertar&isbn=<%=request.getParameter("isbn")%>">INSERTAR NUEVO CAPITULO</a>
	</p>
	<p>
	<a href="ServletControlador">VOLVER A LA LISTA DE LIBROS</a>
	</p>
</body>
</html> 