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
<link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
	<div id="navbar">
		<a href="/register" class="aTags">Sign up</a> &nbsp|&nbsp
		<a href="/loginNow" class="aTags">Log in</a>
	</div>
	<h2 id="logo">MY JOURNEY</h2>
	<div id="main">
		<div id="login">
			<h3>Already have an account?</h3>
			<h5>Login!</h5>
		    <p><c:out value="${error}" /></p>
		    <form method="post" action="/login">
		        <div>
		            <input type="text" id="email" name="email"/><br>
		            <label for="email" class="label">EMAIL</label>
		        </div>
		        <div>
		            <input type="password" id="password" name="password"/><br>
		            <label for="password" class="label">PASSWORD</label>
		        </div>
		        <button type="submit" class="btn btn-primary">Login</button>
		    </form>  
		</div>
	</div>
</body>
</html>