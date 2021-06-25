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
		<a href="/logout">Logout</a>
	</div>
	<h3>Create a New Task</h3>
	<form:form action="/tasks/create" method="post" modelAttribute="task" id="newForm">
		<form:hidden value="${user.id}" path="creator"/>
		<form:errors path="job"/>
		<form:errors path="assignee"/>
		<form:errors path="priority"/>
	    <div class="mb-3 w-25">
	        <form:label path="job" for="job" class="form-label">Task</form:label>
	        <form:input path="job" type="text" class="form-control" id="job"/>
	    </div>
  		<div class="form-group w-25">
			<form:label path="assignee">Assignee</form:label> <!-- need path when using form: something -->
 			<form:select path="assignee" class="form-control"> <!-- this is where we are making the linkage -->
				<c:forEach items="${users}" var="user" varStatus="loop">
                         <form:option value="${user.name}">${user.name}</form:option>
           		</c:forEach>
		  	</form:select>
		</div>
		<div class="form-group w-25">
			<form:label path="priority">Priority</form:label> <!-- need path when using form: something -->
 			<form:select path="priority" class="form-control"> <!-- this is where we are making the linkage -->
				<form:option value="low">Low</form:option>
				<form:option value="medium">Medium</form:option>
				<form:option value="high">High</form:option>
		  	</form:select>
		</div>
	    <button type="submit" class="btn btn-info">Create</button>
	</form:form>
</body>
</html>