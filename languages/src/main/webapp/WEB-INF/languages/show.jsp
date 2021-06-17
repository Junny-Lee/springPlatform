<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

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
<!-- <link rel="stylesheet" type="text/css" href="css/index.css"> -->
</head>
<body>
	<a href="/languages">Dashboard</a>
	<h3><c:out value="${language.name}"/></h3>
	<p>Creator: <c:out value="${language.creator}"/></p>
	<p>Current Version: <c:out value="${language.currentVersion}"/></p>
	<a href="/languages/${language.id}/delete">Delete</a>
	<a href="/languages/${language.id}/edit">Edit</a>

</body>
</html>