<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Developer</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Developer details</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
            <th>ID</th>
            <td><c:out value="${developer.id}"/></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><c:out value="${developer.name}"/></td>
        </tr>
        <tr>
            <th>Age</th>
            <td><c:out value="${developer.age}"/></td>
        </tr>
        <tr>
            <th>Gender</th>
            <td><c:out value="${developer.gender}"/></td>
        </tr>
        <tr>
            <th>Salary</th>
            <td><c:out value="${developer.salary}"/></td>
        </tr>
        <tr>
            <th>Company</th>
            <td><c:out value="${developer.company.name}"/></td>
        </tr>
        </table>
        </p>
    </body>
</html>