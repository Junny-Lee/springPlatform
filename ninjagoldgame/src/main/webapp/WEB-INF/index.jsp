<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- bootstrap -->
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<!-- <style>
	.red{
		color : red;
	}
	.green{
		color : green;
	}
</style> -->
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<div id="mainbody">
		<div id="navbar">		
			<div>Your Gold: <c:out value="${gold}"></c:out></div>
			<a href="/clear">Reset Game</a>
		</div>
		<div id="actions">
			<form method="POST" action="/process">
				<label for="farm">Farm<br>(earns 10-20 gold)</label>
				<input type="hidden" name="location" value="farm">
				<button type="submit" class="btn btn-primary">Find Gold!</button>
			</form>
			<form method="POST" action="/process">	
				<label for="cave">Cave<br>(earns 5-10 gold)</label>
				<input type="hidden" name="location" value="cave">
				<button type="submit" class="btn btn-primary">Find Gold!</button>
			</form>
			<form method="POST" action="/process">	
				<label for="House">House<br>(earns 2-5 gold)</label>
				<input type="hidden" name="location" value="house">
				<button type="submit" class="btn btn-primary">Find Gold!</button>
			</form>
			<form method="POST" action="/process">	
				<label for="casino">Casino!<br>(earns/takes 0-50 gold)</label>
				<input type="hidden" name="location" value="casino">
				<button type="submit" class="btn btn-primary">Find Gold!</button>
			</form>
		</div>
		<div id="bottomhalf">
			Activities:
			<div id="activity">
				<c:forEach items="${activityArr}" var="activity" varStatus="loop">
					<%-- <c:if test=""></c:if> --%>
                   	<p>${activity}</p>
            	</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>