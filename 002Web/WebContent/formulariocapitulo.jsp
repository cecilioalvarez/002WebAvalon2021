<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletControladorCapitulo" method="POST">
		<p>ISBN: <input type="text" name="isbn" value=<%=request.getAttribute("isbn")%>/></p>
		<p>Titulo: <input type="text" name="titulo" /></p>
		<p>Paginas: <input type="text" name="paginas" />  </p>
		
		
		<input type="hidden" name="accion" value="insertar" />
		<input type="submit" value="enviar datos" />
	</form>
</body>
</html>