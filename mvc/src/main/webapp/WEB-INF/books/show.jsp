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
<!-- <link rel="stylesheet" type="text/css" href="css/index.css"> -->
</head>
<body>  
	<h1><c:out value="${book.title}"/></h1>
	<p>Description: <c:out value="${book.description}"/></p>
	<p>Language: <c:out value="${book.language}"/></p>
	<p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
	<a href="/books/${book.id}/edit">Edit Book</a>
	<form action="/books/${book.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <button type="submit" class="btn btn-info">Delete</button>
	</form>
</body>
</html>