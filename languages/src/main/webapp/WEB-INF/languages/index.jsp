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
<link rel="stylesheet" type="text/css" href="css/indexStyle.css">
</head>
<body>
	<h3>All Languages</h3>
	<table class="table">
	    <thead>
	        <tr>
	            <th scope="col">Name</th>
	            <th scope="col">Creator</th>
	            <th scope="col">Version</th>
	            <th scope="col">actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${languages}" var="language">
		        <tr>
		            <td><a href="/languages/${language.id }"><c:out value="${language.name}"/></a></td>
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.currentVersion}"/></td>
		            <td><a href="/languages/${language.id}/delete">Delete</a> | <a href="/languages/${language.id}/edit">Edit</a></td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<hr>
	<h3>New Language</h3>
	<form:form action="/languages" method="post" modelAttribute="language">
		<form:errors id="errors" path="name"/> <!-- put error messages at the top  -->
		<form:errors id="errors" path="creator"/>
		<form:errors id="errors" path="currentVersion"/>
	    <p>
	        <form:label path="name">Name</form:label>
	        <%-- <form:errors path="name"/> --%>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <%-- <form:errors path="creator"/> --%>
	        <form:textarea path="creator"/>
	    </p>
	    <p>
	        <form:label path="currentVersion">currentVersion</form:label>
	        <%-- <form:errors path="currentVersion"/> --%>
	        <form:input path="currentVersion"/>
	    </p>
	    <button type="submit" class="btn btn-info">Submit</button>
	</form:form>
	<!-- <a href="/languages/new">New language</a> -->
</body>
</html>