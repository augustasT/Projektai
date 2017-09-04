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

<title>Klausimynas baigtas</title>

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
p{
margin-left: 50px;
font-size: large;

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
</style>
</head>



<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<span class="navbar-brand" color:"white">Vartotojas:</span>  
			<span class="navbar-brand" color:"white"> <c:forEach items="${userList}" var="user">
					<c:if test="${user.getId() == userId}">
						<i>${user.getName()} ${user.getLastName()}</i>
					</c:if>
				</c:forEach>
				</span>  
				<a href="https://www.google.com/" class="navbar-brand"> Google</a>
			<a href="start" class="navbar-brand">Atsijungti</a>
		</div>
	</div>


<p font-size:250%;><b><i>Jusu rezultatai </b></i></p>

	</br>

	<table aling:"center" class="table-striped">




		<tr>
			<b>
				<th width=150px;>Nr.</th>
				<th>Klausimas</th>
				<th>Jusu atsakymas</th>
			</b>
		</tr>

		<c:forEach items="${questionList}" var="question">
			<c:if test="${question.getId()>4}">
				<tr>
					<td class="counterCell"></td>

					<td>${question.getQuestion()}</br></td>

					<td><c:forEach items="${answerList}" var="answer">
							<c:if test="${answer.getQuestionId()==question.getId()}">
								<c:if test="${answer.getUserId()==userId}">							
							${answer.getAnswer()} 
							</c:if>
							</c:if>
							</br>
						</c:forEach></td>
				</tr>
			</c:if>
		</c:forEach>


	</table>
	<button class="btn btn-primary">
		<a class="white" href="start">atsijungti</a>
	</button>
</body>
</html>
