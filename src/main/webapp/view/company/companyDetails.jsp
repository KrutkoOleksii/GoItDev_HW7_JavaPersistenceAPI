<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Company</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Company details</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
            <th>ID</th>
            <td><c:out value="${company.id}"/></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><c:out value="${company.name}"/></td>
        </tr>
        <tr>
            <th>Code</th>
            <td><c:out value="${company.code}"/></td>
        </tr>
        </table>
        </p>
    </body>
</html>