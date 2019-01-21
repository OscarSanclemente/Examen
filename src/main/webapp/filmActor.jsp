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

<table border="1">
	<thead>
		<tr>
			<td>Cod</td>
			<td>Title</td>
			<td>codDirector</td>
			<td>Asociar Actor</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="film" items="${listAllFilms}">
			<tr>
				<td><c:out value="${film.cod}"/> </td>
				<td><c:out value="${film.title}"/> </td>
				<td><c:out value="${film.codDirector}"/> </td>
				<td><a href="/actorFilm?cod=${film.cod}">Asociar actor</a> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

<a href="/index.jsp">Volver a la página de inicio</a>
</body>
</html>