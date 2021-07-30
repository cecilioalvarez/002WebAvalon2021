<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- la etiqueta form para delimitar el formulario -->
<!--  url del servlet de hola  -->
	<form action="ServletControladorCapitulos" method="POST">
		<!--  he usado las etiquetas input para diseñar el formulario -->
		<p>
		ISBN: <input type="text" name="isbn" value=<%=request.getAttribute("isbn")%> />
		</p>
		<p>
		titulo: <input type="text" name="titulo" />
		</p>
		<p>
		paginas: <input type="text" name="paginas" />
		</p>
		 <input type="hidden" name="accion" value="insertar"/>
		<input type="submit" value="enviar datos"/>
	</form>
</body>
</html>