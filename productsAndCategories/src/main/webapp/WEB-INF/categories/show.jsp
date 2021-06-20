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
<link rel="stylesheet" type="text/css" href="/css/categories/show.css">
</head>
<body>
 	<div id="navbar">
		<div id="navbarLinks">			
			<a href="/categories">Back to List of Categories</a>
		</div>
	</div>
	<h3><c:out value="${category.name} "/></h3>
	<div id="body">
		<div id="productsList">
			<h4>Products:</h4>
			<ul class="list-group">
				<c:forEach items="${category.products}" var="p">
					<li class="list-group-item"><c:out value="${p.name}"></c:out></li>
				 </c:forEach>
			</ul>
		</div>
		<form:form action="/categories/${category.id}" method="post" modelAttribute="category" id="newForm">
			<div class="form-group w-100" id="availableCategories">
				<form:label path="products"><h4>Add Products:</h4></form:label> <!-- need path when using form: something -->
	 			<form:select path="products" class="form-control" multiple="false"> 
	 				<option value="" disabled selected>Please pick a Product to Add!</option>
					<c:forEach items="${availableProd}" var="category" varStatus="loop">
	                         <form:option value="${category.id}">${category.name}</form:option>
	           		</c:forEach>
			  	</form:select>
			  	<button type="submit" class="btn btn-info">Add</button>
			</div>
		</form:form>
	</div>
</body>
</html>