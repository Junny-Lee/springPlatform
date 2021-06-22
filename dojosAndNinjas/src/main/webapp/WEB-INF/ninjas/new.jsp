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
			<a href="/ninjas">Back to List of Ninjas</a>
		</div>
	</div>
	<h3>New Ninja</h3>
	<form:form action="/ninjas" method="post" modelAttribute="ninja" id="newForm">
		<%-- <form:errors path="firstName"/>
		<form:errors path="lastName"/>  --%>
		<div class="form-group w-50">
			<form:label path="dojo">Dojo:</form:label> <!-- need path when using form: something -->
 			<form:select path="dojo" class="form-control"> <!-- this is where we are making the linkage -->
 				<option value="" disabled selected>Please pick a Dojo!</option>
				<c:forEach items="${dojos}" var="dojo" varStatus="loop">
                         <form:option value="${dojo.id}">${dojo.name}</form:option>
           		</c:forEach>
		  	</form:select>
		</div>
	    <div class="mb-3 w-50">
	        <form:label path="firstName" for="firstName" class="form-label">First Name</form:label>
	        <form:input path="firstName" type="text" class="form-control" id="firstName"/>
	    </div>
	    <div class="mb-3 w-50">
	        <form:label path="lastName" for="lastName" class="form-label">Last Name</form:label>
	        <form:input path="lastName" type="text" class="form-control" id="lastName"/>
	    </div>
	    <div class="mb-3 w-50">
	        <form:label path="age" for="age" class="form-label">Age</form:label>
	        <form:input path="age" type="number" class="form-control" id="age"/>
	    </div>
	    <button type="submit" class="btn btn-info">Create</button>
	</form:form>  
</body>
</html>