<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Persons Index</title>
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
			<a href="/licenses">Go to Table of Licenses &nbsp&nbsp</a>
			<a href="/persons/new">New Person</a>
		</div>
	</div>
	<h3>All Persons</h3>
	<div id="table">
		<table class="table table-striped">
		    <thead>
		        <tr>
		            <th scope="col">Name</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${persons}" var="person">
			        <tr>
			            <td><a href="/persons/${person.id}"><c:out value="${person.firstName} ${person.lastName}"/></a></td>
			        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>