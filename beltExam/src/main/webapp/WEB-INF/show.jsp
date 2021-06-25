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
<!-- <link rel="stylesheet" type="text/css" href="/css/index.css"> -->
</head>
<body>
 	<div id="navbar">
		<a href="/tasks">Back</a>
	</div>
	<h2>Task: <c:out value="${task.job}"/></h2>
	<p>Creator: <c:out value="${task.creator.name}"/></p>
	<p>Assignee: <c:out value="${task.assignee}"/></p>
	<p>Priority: <c:out value="${task.priority}"/></p>
	<br><br>
	<a href="/tasks/${task.id}/edit">Edit</a>
</body>
</html>