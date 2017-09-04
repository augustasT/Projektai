
<!DOCTYPE HTML>
<%@page import="springApp.controller.dto.UserDTO"%>
<%@page import="org.apache.catalina.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Registracija | Home</title>

<%--	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache"> --%>
<meta name="descripton" content="" />
<meta name="viewport" content="width=device-width" />
<base href="/" />

<link href="webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="webjars/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"href\"webjars/font-awesome/css/font-awesome.min.css"></link>


<style>
body{
font-style: Verdana;
}
table {
	counter-reset: tableCount;
	width: 70%;
	margin-left: 50px;
}

.counterCell:before {
	content: counter(tableCount);
	counter-increment: tableCount;
}

th {font-size = 15;
	
}

.white {
	color: white;
}

.btn {
	color: white;
	margin-left: 50px;
}
p{
margin-left: 50px;
font-size: large;

}
</style>



</head>

<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="https://www.facebook.com/" class="navbar-brand">Facebook</a>
			<a href="https://www.google.com/" class="navbar-brand"> Google</a> <a
				href="localhost/phpmyadmin/" class="navbar-brand">MySQL</a>


		</div>
	</div>








<form:form method="POST" action="/receiveAnswer" modelAttribute="user">
	<table class="table-striped">
<p font-size:250%;><b><i>Registracija </b></i></p>
		<tr>
			<th>Nr.</th>
			<th>Klausimas</th>
			<th>Atsakymas</th>
		</tr>



		<c:forEach items="${questionList}" var="question">
			<c:if test="${question.getId()<5}">
				<tr>
					<td>${question.getId()}</td>

					<td>${question.getQuestion()}</td>

					<td><c:choose>


							<c:when test="${question.getType() == 'checkbox'}">
								<p>
									<c:forEach items="${question.getAnswers()}" var="answer">

										<input type="checkbox" name="choice"
											value="${answer.getAnswer()}" />${answer.getAnswer()}
									</br>

									</c:forEach>
								</p>


							</c:when>

							<c:when test="${question.getType() == 'select'}">


								<select name="gender">
									<c:forEach items="${question.getAnswers()}" var="answer">
										<option value="${answer.getAnswer()}"> ${answer.getAnswer()}</option>
									</c:forEach>
								</select>

							</c:when>
							<c:when test="${question.getType() == 'password'}">
								<form>
									<input type="password" name="password">
								</form>
							</c:when>

							<c:otherwise>

								<form:input path="name" />
								<form:input path="lastName" />

							</c:otherwise>
						</c:choose></td>


				</tr>
			</c:if>
		</c:forEach>



	</table>
	<button type="submit" class="btn btn-primary">
		Registruotis <span class="primary"> </span>
	</button>
</form:form>
</body>
</html>

