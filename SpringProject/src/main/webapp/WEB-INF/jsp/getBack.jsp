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

<title>Naujas klausimas</title>

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
	width: 50%;
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
			<a href="https://www.google.com/" class="navbar-brand"> Google</a>
		</div>
	</div>


<p font-size:250%;><b><i>Klausimas uzregistruotas!</b></i></p>

	
<button class="btn btn-primary">
		<a class="white" href="start">Grizti i pradzia</a>
	</button>
</body>
</html>
