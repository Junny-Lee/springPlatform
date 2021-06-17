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
<link rel="stylesheet" type="text/css" href="/css/show.css">
</head>
<body>
	<div id="navbar">
		<a href="/songs">Dashboard</a>
	</div>
	<div id="body">
		<h4>Title: <c:out value="${song.title}"/></h4>
		<h4>Artist: <c:out value="${song.artist}"/></h4>
		<h4>Rating (1-10): <c:out value="${song.rating}"/></h4>
	    <form action="/songs/${song.id}/delete" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <button type="submit" class="btn btn-link">Delete</button>
		</form>
	</div>
</body>
</html>

