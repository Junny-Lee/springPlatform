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
<link rel="stylesheet" type="text/css" href="/css/topTen.css">
</head>
<body>
	<div id="navbar">		
		<a href="/songs">Dashboard</a>
	</div>
	<h4>Top Ten Songs:</h4>
	<div id="topTen">
	    <ul>
			<c:forEach items="${songs}" var="song">
	       	 	<li id="listItems">
	       	 		<c:out value="${song.rating}"/>
	       	 		<p>&nbsp-&nbsp</p>
	       	 		<a href="/songs/${song.id}"><c:out value="${song.title}"/></a>
	       	 		<p>&nbsp-&nbsp</p>
	       	 		<c:out value="${song.artist}"/>
	       	 	</li>	
	    	</c:forEach>
	    </ul>
	</div>
</body>
</html>