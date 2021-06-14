<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
	<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<title>Forms</title>
</head>
<body>
	<form method="POST" action="/result">
	  <div class="form-group">
	    <label for="name">Your name:</label>
	    <input type="text" class="form-control" id="text">
	  </div>
	  <div class="form-group">
	    <label for="location">Dojo Location:</label>
	    <select class="form-control" id="location">
	      <option>San Jose</option>
	      <option>Remote</option>
	      <option>Irvine</option>
	      <option>Los Angeles</option>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="language">Favorite Language:</label>
	    <select class="form-control" id="language">
	      <option>Python</option>
	      <option>Java</option>
	      <option>Javascript</option>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="comment">Comments (optional):</label>
	    <textarea class="form-control" id="comment" rows="3"></textarea>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>