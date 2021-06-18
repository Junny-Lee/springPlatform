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
<h3>All Licenses</h3>
<div id="table">
		<table class="table table-striped">
		    <thead>
		        <tr>
		            <th scope="col">Number</th>
		            <th scope="col">Expiration Date</th>
		            <th scope="col">State</th>
		            <th scope="col">Person</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${licenses}" var="license">
			        <tr>
			            <td><c:out value="${license.number}"/></td>
			            <td><c:out value="${license.expirationDate}"/></td>
			            <td><c:out value="${license.state}"/></td>
			            <td><c:out value="${license.person}"/></td>
			        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>