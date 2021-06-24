<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!-- to format date -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<!-- bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- link css -->
<link rel="stylesheet" type="text/css" href="/css/homePage.css">
</head>
<body>
 	<div id="navbar">		
		<h2 id="welcome">Welcome, <c:out value="${user.firstName}" /></h2>
		<a href="/logout">Logout</a>

	</div>
	<h5 class="tableTitle">Here are some of the events in your state (<c:out value="${user.state}"/>):</h5>
	<table class="table table-striped"">
	    <thead>
	        <tr>
	            <th scope="col">Name</th>
	            <th scope="col">Date</th>
	            <th scope="col">Location</th>
	            <th scope="col">Host</th>
	            <th scope="col">Action / Status</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${eventsInSameState}" var="e">
		        <tr>
		            <td><a href="/events/${e.id}"><c:out value="${e.name}"/></a></td>
		            <td><fmt:formatDate value="${e.date}" pattern="MMMM dd, yyyy"/></td>
		            <td><c:out value="${e.location}"/></td>
		            <td><c:out value="${e.creator.firstName}"/></td>
		            <td>
		            	<c:if test = "${e.creator.firstName == user.firstName}">
		            		<a href="/events/${e.id}/edit">Edit</a>
						    <%-- <form action="/events/${e.id}/delete" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <button type="submit" class="btn btn-warning">Delete</button>
							</form> --%>
							<a href="/events/${e.id}/delete">Delete</a>
		            	</c:if>
		            	<c:if test = "${e.creator.firstName != user.firstName}">
						    <a href="/join/${e.id}">Join</a>
		            	</c:if>
		            </td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<br></br>
	<h5 class="tableTitle">Here are some of the events in other states:</h5>
		<table class="table table-striped">
	    <thead>
	        <tr>
	            <th scope="col">Name</th>
	            <th scope="col">Date</th>
	            <th scope="col">Location</th>
	            <th scope="col">State</th>
	            <th scope="col">Host</th>
	            <th scope="col">Action / Status</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${eventsInOtherStates}" var="e">
		        <tr>
		            <td><a href="/events/${e.id}"><c:out value="${e.name}"/></a></td>
		            <td><fmt:formatDate value="${e.date}" pattern="MMMM dd, yyyy"/></td>
		            <td><c:out value="${e.location}"/></td>
		            <td><c:out value="${e.state}"/></td>
		            <td><c:out value="${e.creator.firstName}"/></td>
		            <td><a href="/join/${e.id}">Join</a></td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<br></br>
 	<form:form action="/createEvent" method="post" modelAttribute="event" id="newForm">
		<form:hidden value="${user.id}" path="creator"/>
	<%-- 	<form:errors path="name"/>
		<form:errors path="lastName"/>  --%>
	    <div class="mb-3 w-25">
	        <form:label path="name" for="name" class="form-label">Name</form:label>
	        <form:input path="name" type="text" class="form-control" id="name"/>
	    </div>
	    <div class="mb-3 w-25">
	        <label for="date1" class="form-label">Date</label>
	        <input name="date1" type="date" class="form-control" id="date1"/>
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