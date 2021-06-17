<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<!-- bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- link css -->
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
	<div id="navbar">
		<div id="navbarLinks">			
			<a href="/songs/new">Add New</a>
			<p>&nbsp&nbsp&nbsp&nbsp&nbsp</p> <!-- &nbsp is forcing a space -->
			<a href="/search/topTen">Top Songs</a>
		</div>
		<div id="searchBar">
	         <form action="/search" method="post">
	         	<input type="search" class="form-control" name="name"/>
			    <button type="submit" class="btn btn-primary">Search Artist</button>
			</form>
		</div>
	</div>
	<div id="table">
		<table class="table table-striped">
		    <thead>
		        <tr>
		            <th scope="col">Title</th>
		            <th scope="col">Rating</th>
		            <th scope="col">Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${songs}" var="song">
			        <tr>
			            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
			            <td><c:out value="${song.rating}"/></td>
			            <td>
			            	<form action="/songs/${song.id}/delete" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <button type="submit" class="btn btn-link">Delete</button>
							</form>
			            </td>	
			        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>