<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Insertar</title>
	</head>
	<body>
		<form action="/mvc1/alumnoAdd" method="GET">
			<input type="text" name="nombre" id="nombre" placeholder="Inserta el nombre"/><br>	
			<input type="text" name="apellidos" id="apellidos" placeholder="Inserta los apellidos"/><br>	
			<input type="text" name="edad" id="edad" placeholder="Inserta la edad"/><br>
			<input type="submit" value="Insertar Alumno">
		</form>
	</body>
</html>
