<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Developers</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Developers</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
             <th>id</th>
             <th>Name</th>
             <th>Age</th>
             <th>Gender</th>
             <th>Salary</th>
             <th>Company ID</th>
        </tr>
        <c:forEach var="developer" items="${developers}">
            <tr>
            <td><c:out value="${developer.id}"/></td>
            <td><a href="${PageContext.request.contextPath}/pm/developer/find?id=${developer.id}"><c:out value="${developer.name}"/></a></td>
            <td><c:out value="${developer.age}"/></td>
            <td><c:out value="${developer.gender}"/></td>
            <td><c:out value="${developer.salary}"/></td>
            <td><c:out value="${developer.companyId}"/></td>
            <td><button onclick="location.href='/pm/developer/updateDeveloper?id=${developer.id}'"  class="button"/>UPDATE</button></td>
            <td><button onclick="location.href='/pm/developer/delete?id=${developer.id}'"  class="button"/>DELETE</button></td>
             </tr>
        </c:forEach>
        </table>
        </p>
    </body>
</html>