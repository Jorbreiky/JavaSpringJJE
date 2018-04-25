<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>
			Hello world!  
		</h1>
		
		<P>  Esta es la pagina de test conexion</P>
		<P>  Hola ${alumno}</P>
		<br>
		
		  <c:forEach items="${lista}" var="alumno" >
		     <label> ${alumno.toString()} </label><br>
		  </c:forEach>
		
	</body>
</html>
