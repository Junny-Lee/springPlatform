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
		<div id="navbarLinks">			
			<a href="/categories">Back to List of Categories</a>
		</div>
	</div>
	<h3>New Category</h3>
	<form:form action="/categories" method="post" modelAttribute="category" id="newForm">
		<%-- <form:errors path="name"/>
		<form:errors path="description"/>  --%>
	    <div class="mb-3 w-50">
	        <form:label path="name" for="name" class="form-label">Name</form:label>
	        <form:input path="name" type="text" class="form-control" id="name"/>
	    </div>
	    <button type="submit" class="btn btn-info">Create</button>
	</form:form> 
</body>
</html>