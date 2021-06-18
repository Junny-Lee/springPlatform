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
			<a href="/licenses">Back to List of Licenses</a>
		</div>
	</div>
	<h3>New License</h3>
	<form:form action="/licenses" method="post" modelAttribute="license" id="newForm">
		<form:errors path="state"/>
		<div class="form-group w-50">
			<form:label path="person">Person:</form:label> <!-- need path when using form: something -->
 			<form:select path="person" class="form-control">
				<c:forEach items="${persons}" var="person" varStatus="loop">
                         <form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
           		</c:forEach>
		  	</form:select>
		</div>
	    <div class="mb-3 w-50">
	        <form:label path="state" for="state" class="form-label">State</form:label>
	        <form:input path="state" type="text" class="form-control" id="state"/>
	    </div>
	    <div class="mb-3 w-50">
	        <form:label path="expirationDate" for="expirationDate" class="form-label">Expiration Date:</form:label>
	        <form:input path="expirationDate" type="date" class="form-control" id="expirationDate"/>
	    </div>
	    <button type="submit" class="btn btn-info">Create</button>
	</form:form>  
</body>
</html>