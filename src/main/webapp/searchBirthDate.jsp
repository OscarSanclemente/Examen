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
	<form action="/actor" method="get">
		<span>year 1:</span> <input type="text" name="year1"> <br />
		<span>year 2:</span> <input type="text" name="year2"> <br />
		<input type="submit">
	</form>
	
	

<table border="1">
	<thead>
		<tr>
			<td>Cod</td>
			<td>Name</td>
			<td>Year</td>
			<td>Eliminar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="actor" items="${listAllActores}">
			<tr>
				<td><c:out value="${actor.cod}"/> </td>
				<td><c:out value="${actor.name}"/> </td>
				<td><c:out value="${actor.year}"/> </td>
				<td><a href="/actor?cod=${actor.cod}">Eliminar</a> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

<a href="/index.jsp">Volver a la página de inicio</a>
</body>
</html>