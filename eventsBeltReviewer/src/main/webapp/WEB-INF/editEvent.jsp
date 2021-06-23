<%@ page isErrorPage="true" %>
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
	<form:form action="/events/${event.id}/process" method="post" modelAttribute="event" id="newForm">
		<%-- <form:hidden value="${event.creator}" path="creator"/> --%>
		<input type="hidden" name="_method" value="put">
	    <div class="mb-3 w-25">
	        <form:label path="name" for="name" class="form-label">Name</form:label>
	        <form:input path="name" type="text" class="form-control" id="name"/>
	    </div>
	    <div class="mb-3 w-25">
	        <label for="date2" class="form-label">Date</label>
	        <input name="date2" type="date" class="form-control" id="date2"/>
	    </div>
	    <div class="mb-3 w-25">
	        <form:label path="location" for="location" class="form-label">Location</form:label>
	        <form:input path="location" type="text" class="form-control" id="location"/>
	    </div>
  		<div class="form-group w-25">
			<form:label path="state"></form:label> <!-- need path when using form: something -->
 			<form:select path="state" class="form-control"> <!-- this is where we are making the linkage -->
				<form:option value="CA">CA</form:option>
				<form:option value="NY">NY</form:option>
				<form:option value="WA">WA</form:option>
				<form:option value="TX">TX</form:option>
				<form:option value="HI">HI</form:option>
		  	</form:select>
		</div>
	    <button type="submit" class="btn btn-info">Create</button>
	</form:form>
</body>
</html>