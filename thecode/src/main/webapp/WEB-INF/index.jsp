<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<form method="POST" action="/check">
		<span id="error"><c:out value="${error}"></c:out></span><br>
	    <label>What is the code?<input type="text" name="code"></label>
	    <button>Try Code</button>
	</form>
</body>
</html>