<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>Submitted Info</h2>
		<h4>Name: <c:out value="${name}"></c:out></h4>
		<h4>Dojo Location: <c:out value="${location}"></c:out></h4>
		<h4>Favorite Language: <c:out value="${language}"></c:out></h4>
		<h4>Comment: <c:out value="${comment}"></c:out></h4>
	</div>
</body>
</html>