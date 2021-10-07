<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Companies</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Companies</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
             <th>id</th>
             <th>Name</th>
             <th>Code</th>
             <th>"UPDATE"</th>
             <th>"DELETE"</th>
        </tr>
        <c:forEach var="company" items="${companies}">
             <tr>
             <td><c:out value="${company.id}"/></td>
             <td><a href="${PageContext.request.contextPath}/pm/company/find?id=${company.id}"><c:out value="${company.name}"/></a></td>
             <td><c:out value="${company.code}"/></td>

             <td><button onclick="location.href='/pm/company/updateCompany?id=${company.id}'"  class="button"/>UPDATE</button></td>
             <td><button onclick="location.href='/pm/company/delete?id=${company.id}'"  class="button"/>DELETE</button></td>
             </tr>
        </c:forEach>
        </table>
        </p>
    </body>
</html>