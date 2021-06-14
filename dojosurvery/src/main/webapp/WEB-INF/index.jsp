<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forms</title>
</head>
<body>
	<form method="POST" action="/result">
	    <label>Your Name:<input type="text" name="name"></label>
	    <label for="location">Dojo Location:</label>
			<select id="location" name="location">
			  <option value="sanjose">San Jose</option>
			  <option value="irvine">Irvine</option>
			  <option value="losangeles">Los Angeles</option>
			</select>
		<label for="language">Dojo Location:</label>
			<select id="language" name="language">
			  <option value="python">Python</option>
			  <option value="java">Java</option>
			  <option value="javascript">Javascript</option>
			</select>
	    <button>Submit</button>
	</form>
</body>
</html>