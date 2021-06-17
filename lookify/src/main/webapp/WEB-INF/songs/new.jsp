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
<link rel="stylesheet" type="text/css" href="/css/new.css">
</head>
<body>
	<div id="navbar">
		<a href="/songs">Dashboard</a>
	</div>
	<form:form action="/songs" method="post" modelAttribute="song" id="newForm">
		<form:errors path="title"/>
		<form:errors path="artist"/>
		<form:errors path="rating"/>  
	    <div class="mb-3 w-50">
	        <form:label path="title" for="title" class="form-label">Title</form:label>
	        <form:input path="title" type="text" class="form-control" id="title"/>
	    </div>
	    <div class="mb-3 w-50">
	        <form:label path="artist" for="artist" class="form-label">Artist</form:label>
	        <form:input path="artist" type="text" class="form-control" id="artist"/>
	    </div>
	    <div class="mb-3 w-50">
	        <form:label path="rating" for="rating" class="form-label">Rating (1-10)</form:label>
	        <form:input path="rating" type="number" class="form-control" id="rating"/>
	    </div>
	    <button type="submit" class="btn btn-info">Add Song</button>
	</form:form>  
</body>
</html>