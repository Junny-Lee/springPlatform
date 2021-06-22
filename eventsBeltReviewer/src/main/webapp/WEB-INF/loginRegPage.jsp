<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<!-- bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- link css -->
<link rel="stylesheet" type="text/css" href="/css/loginRegPage.css">
</head>
<body>
	<h2 id="welcome">Welcome</h2>
	<div id="main">
		<div id="register">
		    <h3>Register!</h3>
		    
		    <p><form:errors path="user.*"/></p>
		    
		    <form:form method="POST" action="/registration" modelAttribute="user">
		    	 <p>
		            <form:label path="firstName">First Name:</form:label>
		            <form:input type="text" path="firstName"/>
		        </p>
		        <p>
		            <form:label path="lastName">Last Name:</form:label>
		            <form:input type="text" path="lastName"/>
		        </p>
		        <div id="locationState">
			        <p>
			            <form:label path="location">Location:</form:label>
			            <form:input type="text" path="location"/>
			        </p>
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
		        </div>
		        <p>
		            <form:label path="email">Email:</form:label>
		            <form:input type="email" path="email"/>
		        </p>
		        <p>
		            <form:label path="password">Password:</form:label>
		            <form:password path="password"/>
		        </p>
		        <p>
		            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
		            <form:password path="passwordConfirmation"/>
		        </p>
		        <button type="submit" class="btn btn-info">Register</button>
		    </form:form>
		</div>
		<div id="login">
			<h3>Login</h3>
		    <p><c:out value="${error}" /></p>
		    <form method="post" action="/login">
		        <p>
		            <label for="email">Email</label>
		            <input type="text" id="email" name="email"/>
		        </p>
		        <p>
		            <label for="password">Password</label>
		            <input type="password" id="password" name="password"/>
		        </p>
		        <button type="submit" class="btn btn-info">Login</button>
		    </form>  
		</div>
	</div>
</body>
</html>