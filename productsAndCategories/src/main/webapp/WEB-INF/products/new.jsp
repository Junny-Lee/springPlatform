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
			<a href="/products">Back to List of Products</a>
		</div>
	</div>
	<h3>New Product</h3>
	<form:form action="/products" method="post" modelAttribute="product" id="newForm">
		<%-- <form:errors path="name"/>
		<form:errors path="description"/>  --%>
	    <div class="mb-3 w-50">
	        <form:label path="name" for="name" class="form-label">Name</form:label>
	        <form:input path="name" type="text" class="form-control" id="name"/>
	    </div>
	    <div class="mb-3 w-50">
	        <form:label path="description" for="description" class="form-label">Description</form:label>
	        <form:input path="description" type="text" class="form-control" id="description"/>
	    </div>
	    <div class="mb-3 w-50">
	        <form:label path="price" for="price" class="form-label">Price</form:label>
	        <form:input path="price" type="float" class="form-control" id="price"/>
	    </div>
	    <button type="submit" class="btn btn-info">Create</button>
	</form:form>  
</body>
</html>