<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<!-- bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- link css -->
<!-- <link rel="stylesheet" type="text/css" href="/css/index.css"> -->
</head>
<body>
 	<div id="navbar">		
		<h2 id="welcome">Welcome, <c:out value="${user.name}" /></h2>
		<a href="/logout">Logout</a>
	</div>
	<br><br>
	<table class="table table-striped">
	    <thead>
	        <tr>
	            <th scope="col">Task</th>
	            <th scope="col">Creator</th>
	            <th scope="col">Assignee</th>
	            <th scope="col">Priority</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${tasks}" var="t">
		        <tr>
		            <td><a href="/tasks/${t.id}"><c:out value="${t.job}"/></a></td>
		            <td><c:out value="${t.creator.name}"/></td>
		            <td><c:out value="${t.assignee}"/></td>
		            <td><c:out value="${t.priority}"/></td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<br><br>
	<a href="/tasks/new">Create Task</a>
</body>
</html>





