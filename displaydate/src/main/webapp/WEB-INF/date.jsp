<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date right now</title>
<script type="text/javascript" src="js/dateAlert.js"></script>
<link rel="stylesheet" type="text/css" href="css/date.css">
</head>
<body>
	<c:out value="${date}"/>
</body>
</html>