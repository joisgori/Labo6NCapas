<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="student">
	
		<label>Ingrese su nombre: </label>
		<form:input type="text" name="name" path="sName"/><br>
		
		<label>Ingrese su apellido: </label>
		<form:input type="text" name="lname" path="lName"/><br>
		
		<label>Ingrese su edad: </label>
		<form:input type="number" name="age" path="sAge"/><br>
		
		<label>Estado del estudiante</label>
		<form:radiobutton name="status" path="bActivo" value="true"/><label>Activo</label>
		<form:radiobutton name="status" path="bActivo" value="false"/><label>Inactivo</label>
		
		<input type="submit" value="Agregar estudiante">
	</form:form>
	
	

</body>
</html>