<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!-- link css -->

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
<link rel="stylesheet" type="text/css" href="/css/products/show.css">
</head>
<body>
 	<div id="navbar">
		<div id="navbarLinks">			
			<a href="/products">Back to List of Products</a>
		</div>
	</div>
	<h3><c:out value="${product.name} "/></h3>
	<div id="body">
		<div id="categoriesList">
			<h4>Categories:</h4>
			<ul class="list-group">
				<c:forEach items="${product.categories}" var="c">
					<li class="list-group-item"><c:out value="${c.name}"></c:out></li>
				 </c:forEach>
			</ul>
		</div>
		<form:form action="/products/${product.id}" method="post" modelAttribute="product" id="newForm">
			<div class="form-group w-100" id="availableCategories">
				<form:label path="categories"><h4>Add Category:</h4></form:label> <!-- need path when using form: something -->
	 			<form:select path="categories" class="form-control" multiple="false"> 
	 				<option value="" disabled selected>Please pick a Category to Add!</option>
					<c:forEach items="${availableCat}" var="category" varStatus="loop">
	                         <form:option value="${category.id}">${category.name}</form:option>
	           		</c:forEach>
			  	</form:select>
			  	<button type="submit" class="btn btn-info">Add</button>
			</div>
		</form:form>
	</div>
</body>
</html>