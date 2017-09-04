<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<body>
	<form:form method="POST" action="/receiveAnswer" modelAttribute="user">
    
    
    <c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.getId()}</td>
					<td>${user.getName()}</td>		
					<td>${user.getGender()}</td>
					</br>

				</tr>
			</c:forEach>
	
	<a href="start" class="navbar-brand">Grizti i pradzios ekrana</a>
	</form:form>


</body>

</html>