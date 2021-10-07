<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Project</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Project details</h2>
        <p>
            <table border=1 cellpadding=8>
                <tr>
                    <th>ID</th>
                    <td><c:out value="${project.id}"/></td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td><c:out value="${project.name}"/></td>
                </tr>
                <tr>
                    <th>Cost</th>
                    <td><c:out value="${project.cost}"/></td>
                </tr>
                <tr>
                    <th>Start date</th>
                    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
                    <jsp:useBean id="dateValue" class="java.util.Date"/>
                    <jsp:setProperty name="dateValue" property="time" value="${project.startDate}"/>
                    <td><fmt:formatDate value="${dateValue}" pattern="dd/MM/yyyy"/></td>
                </tr>
                <tr>
                    <th>Company</th>
                    <td><c:out value="${company.name}"/></td>
                </tr>
                <tr>
                    <th>Customer</th>
                    <td><c:out value="${customer.name}"/></td>
                </tr>
            </table>
        </p>
    </body>
</html>