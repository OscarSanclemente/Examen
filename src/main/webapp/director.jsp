<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	<form action="/director" method="post">
		<span>name:</span> <input type="text" name="name"> <br />
		<input type="submit">
	</form>

<table border="1">
	<thead>
		<tr>
			<td>Cod</td>
			<td>Name</td>
			<td>Eliminar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="director" items="${listAllDirectores}">
			<tr>
				<td><c:out value="${director.cod}"/> </td>
				<td><c:out value="${director.nombre}"/> </td>
				<td><a href="/director?cod=${director.cod}">Eliminar</a> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

<a href="/index.jsp">Volver a la página de inicio</a>
</body>
</html>