<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Actualizar</title>
	</head>
	<body>
		<form action="/mvc1/alumnoUpdate" method="GET">
			<input type="hidden" name="alumnoId" id="alumnoId" value="${alumno.getAlumnoId()}"/>
			<input type="text" name="nombre" id="nombre" value="${alumno.getNombre()}"/><br>	
			<input type="text" name="apellidos" id="apellidos" value="${alumno.getApellidos()}"/><br>	
			<input type="text" name="edad" id="edad" value="${alumno.getEdad()}"/><br>
			<input type="submit" value="Actualizar Alumno">
		</form>
	</body>
</html>
