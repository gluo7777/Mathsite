<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Math Problems</title>
</head>
<body>
	<%-- <c:set var="data" value="dog,cat,mouse,turkey"></c:set>
	<c:set var="dataSplit" value="${fn:split(data,',') }"></c:set>
	<ol>
		<c:forEach var="animal" items="${dataSplit}">
			<li>${animal}</li>
		</c:forEach>
	</ol>
	<c:set var="data2" value="dog,cat,mouse,turkey"></c:set>
	<ol>
		<c:forEach var="animal" items="${data2}">
			<li>${animal}</li>
		</c:forEach>
	</ol> --%>
	<h1>Today's date is <%= LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.US)) %></h1>
</body>
</html>