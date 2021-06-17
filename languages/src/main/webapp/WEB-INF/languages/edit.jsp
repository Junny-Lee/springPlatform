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
<!-- <link rel="stylesheet" type="text/css" href="css/editStyle.css"> -->
</head>
<body>
	<a href="/languages/${language.id}/delete">Delete</a> | <a href="/languages">Dashboard</a>
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		<form:errors path="name"/><br> <!-- put error messages at the top  -->
		<form:errors path="creator"/><br>
		<form:errors path="currentVersion"/><br>
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
</body>
</html>