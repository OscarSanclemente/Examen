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
	<form action="/cacheActor" method="post">
		<span>Cache:</span> <input type="text" name="cache"> <br />
		<span>Personaje interpretado:</span> <input type="text" name="personaje"> <br />
		<input type="text" name="cod" style="display:none" value=<%= request.getParameter("cod") %>><br>
		<input type="text" name="codActor" style="display:none" value=<%= request.getParameter("codActor") %>><br>
		<input type="submit">
	</form>

<a href="/index.jsp">Volver a la página de inicio</a>
</body>
</html>