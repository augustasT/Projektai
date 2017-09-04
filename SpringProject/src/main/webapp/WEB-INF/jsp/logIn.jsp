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

<title>Prisijungimas</title>

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
body {
	font-style: Verdana;
}

label {
	color: red;
}

table {
	border-radius: 25px;
}

table, th, td {
	border-collapse: collapse;
	opacity: 0.95;
	margin-left: 50px;
	padding: 20px;
	border-radius: 25px;
}

.btn {
	margin-left: 50px;
}

th {
	background-color: grey;
	color: white;
}
</style>
</head>


<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="https://www.google.com/" class="navbar-brand"> Google</a>
		</div>
	</div>

	<form:form method="POST" action="/logincheck" modelAttribute="user">

		<table>
			<tr>
				<th colspan="2"><h3>Prisijunkite</h3></th>
			</tr>
			<c:if test="${invalid}">
				<td><label> neteisingi duomenys </br>
				</label></td>
			</c:if>
			<tr>
				<td>Pavarde:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Slaptazodis:</td>

				<td><form:input type="password" path="password" /></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-primary">
			Prisijungti <span class="primary"></span>
		</button>


	</form:form>

</body>
</html>