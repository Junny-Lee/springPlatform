<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time right now</title>
<script type="text/javascript" src="js/timeAlert.js"></script>
<link rel="stylesheet" type="text/css" href="css/time.css">
</head>
<body>
	<div id="body">
		<c:out value="${time}"/>
	</div>
</body>
</html>