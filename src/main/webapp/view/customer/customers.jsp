<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Customers</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Customers</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
             <th>id</th>
             <th>Name</th>
             <th>Code</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
            <td><c:out value="${customer.id}"/></td>
            <td><a href="${PageContext.request.contextPath}/customer/find?id=${customer.id}"><c:out value="${customer.name}"/></a></td>
            <td><c:out value="${customer.code}"/></td>
            <td><button onclick="location.href='/customer/updateCustomer?id=${customer.id}'"  class="button"/>UPDATE</button></td>
            <td><button onclick="location.href='/customer/delete?id=${customer.id}'"  class="button"/>DELETE</button></td>
            </tr>
        </c:forEach>
        </table>
        </p>
    </body>
</html>