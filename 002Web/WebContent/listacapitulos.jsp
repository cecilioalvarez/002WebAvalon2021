<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.arquitecturajava.negocio.Capitulo"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
			<c:forEach var="capitulos" items="${capitulos}">
				<tr>

					<td>${capitulos.titulo}</td>
					<td>${capitulos.paginas}</td>
					<td><a
                        href="ServletControladorCapitulos?accion=borrar&titulo=${capitulos.titulo}
                    &isbn=${isbn}">borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	 <a
        href="ServletControladorCapitulos?accion=formularioinsertar&isbn=${isbn}">Nuevo
        capitulo</a>
</body>
</html>