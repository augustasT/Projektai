<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<body>
    <form:form method="POST" action="/receiveAnswer" modelAttribute="user">
                   <table>
                                   <tr>
                                       <td><form:label path="name">Vardas ir pavarde</form:label></td>
                                       <td><form:input path="name"/></td>
                                   </tr>
                                   <tr>
                                       <td><input type="submit" value="Submit"/></td>
                                   </tr>
                               </table>
    </form:form>



</body>

</html>