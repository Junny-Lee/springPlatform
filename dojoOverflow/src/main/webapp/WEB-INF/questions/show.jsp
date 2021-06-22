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
<link rel="stylesheet" type="text/css" href="/css/questions/show.css">
</head>
<body>
 	<div id="navbar">
		<div id="navbarLinks">			
			<a href="/questions">Back to Question List</a>
		</div>
	</div>
	<h3><c:out value="${q.myQuestion} "/></h3>
	<div>
		<p>Tags: &nbsp<c:out value="${q.tags}"></c:out></p>
	</div>
	<div id="body">
		<div id="table">
			<table class="table table-striped">
			    <thead>
			        <tr>
			            <th scope="col">Answers:</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${q.answers}" var="answer">
				        <tr>
				            <td><c:out value="${answer.answer}"/></td>
				        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
		<form:form action="/questions/answer" method="post" modelAttribute="newAnswer" id="newForm"> <!-- this was question id before -->
			<form:errors path="answer"></form:errors>
			<%-- <input type="hidden" name="questionId" value="${question.id}"/>  --%><!-- look back!!!!! -->
			<form:hidden path="question" value="${q.getId()}"/>
			<div class="form-group w-100">
				<form:label path="answer"><h4>Add your answer:</h4></form:label> <!-- need path when using form: something -->
			  	<form:textarea path="answer" class="form-control"/>
			  	<button type="submit" class="btn btn-info">Answer it!</button>
			</div>
		</form:form>
	</div>
</body>
</html>