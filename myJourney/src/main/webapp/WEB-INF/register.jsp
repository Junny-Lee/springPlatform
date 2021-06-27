<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

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
<link rel="stylesheet" type="text/css" href="/css/register.css">
</head>
<body>
<div id="navbar">
	<a href="/register" class="aTags">Sign up</a> &nbsp|&nbsp
	<a href="/loginNow" class="aTags">Log in</a>
</div>
<h2 id="logo">MY JOURNEY</h2>
	<div id="main">
		<div id="register">
		    <h3>Don't have an account?</h3>
		    <h5>Register here!</h5>
		    <p><form:errors path="user.*" id="errors"/></p>
		    <form:form method="POST" action="/registration" modelAttribute="user">
		    	<div id="fullName">
			    	<div>
			            <form:input type="text" path="firstName" class="w-75"/><br>
			            <form:label path="firstName" class="label">FIRST NAME</form:label>
			       </div>
			       <div>
			            <form:input type="text" path="lastName" class="w-75"/><br>
			            <form:label path="lastName" class="label">LAST NAME</form:label>
			       </div>
		    	</div>
		       <div>
		            <form:input type="email" path="email" class="w-100"/><br>
		            <form:label path="email" class="label">EMAIL ADDRESS</form:label>
		       </div>
		       <div>
		            <form:password path="password" class="w-100"/><br>
		            <form:label path="password" class="label">PASSWORD</form:label>
		       </div>
		       <div>
		            <form:password path="passwordConfirmation" class="w-100"/><br>
		            <form:label path="passwordConfirmation" class="label">CONFIRM PASSWORD</form:label>
		       </div>
		        <button type="submit" class="btn btn-primary">Create Account</button>
		    </form:form>
		    <br><br>
<%-- 		    <h5 class="sentence">Already have an account?</h5>
			<form:form action="/loginNow" method="post" id="newForm">
			    <button type="submit" class="btn btn-link">Login</button>
			</form:form> --%>
		</div>
	</div>
</body>
</html>