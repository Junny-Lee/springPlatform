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
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- link css -->
<!-- <link rel="stylesheet" type="text/css" href="/css/index.css"> -->
</head>
<body>
	<div id="main">
		<div id="leftSide">
			<h3>${e.name}</h3><br>
			<p>Host: ${e.creator.firstName} ${e.creator.lastName}</p>
			<p>Date: <fmt:formatDate value="${e.date}" pattern="MMMM dd, yyyy"/></p>
			<p>Location: ${e.location}</p>
			<p>People who are attending this event: 
				 <c:forEach items="${e.joinedUsers}" var="person">
			        <ul>
			            <li><c:out value="${person.firstName} ${person.lastName}"/></li>
			        </ul>
		        </c:forEach>
			</p>
		</div>
		<div id="rightSide">
		
		</div>
	</div>
</body>
</html>