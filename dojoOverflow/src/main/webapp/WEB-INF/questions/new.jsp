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
			<a href="/questions">Back to Question List</a>
		</div>
	</div>
	<h3>What is your question?</h3>
	<form:form action="/questions" method="post" modelAttribute="question" id="newForm"> <!-- look at q -->
		<%-- <form:errors path="tags"/> --%>
	    <div class="mb-3 w-50">
	        <form:label path="myQuestion" class="form-label">Question</form:label>
			<form:errors path="myQuestion"/>
	        <form:input path="myQuestion" class="form-control" id="myQuestion"/>
	    </div>
<%-- 	    <div class="mb-3 w-50">
	        <form:label path="tags" for="tags" class="form-label">Tags</form:label>
	        <form:input path="tags" type="text" class="form-control" id="tags"/>
	    </div> --%>
	    <button type="submit" class="btn btn-info">Submit</button>
	</form:form>  
</body>
</html>