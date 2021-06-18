<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!-- to format date -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- link css -->
<!-- <link rel="stylesheet" type="text/css" href="/css/index.css"> -->
</head>
<body>
	<div id="navbar">
		<a href="/persons">Back to Persons List</a>
	</div>
	<div id="body">
		<h3><c:out value="${person.firstName} ${person.lastName}"/></h3>
		<p>License Number: <c:out value="${person.license.id}"/></p>
		<p>State: <c:out value="${person.license.state}"/></p>
		<p>Expiration Date: <fmt:formatDate value="${person.license.expirationDate}" pattern="MM/dd/yyyy"/></p>
	</div>
</body>
</html>