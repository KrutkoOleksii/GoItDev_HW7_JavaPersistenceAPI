<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Save Customer</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Customer parameters:</h2>
        <p>
        <c:if test="${mode == 0}">
            <form name="customerSaveForm" method="post" action="create">
                Name: <input type="text" name="name"/> <br/>
                Code: <input type="text" name="code"/> <br/>

                <input type="submit" value="Add customer"  class="button"/>
            </form>
        </c:if>
        <c:if test="${mode == 1}">
            <form name="customerUpdateForm" method="put" action="update">
                ID: <input readonly type="text" name="id" value=${customer.id} /> <br/>
                New name: <input type="text" name="name" value=${customer.name}  /> <br/>
                New code: <input type="text" name="code" value=${customer.code}  /> <br/>

                <input type="submit" value="Update customer"  class="button"/>
            </form>
        </c:if>
        </p>
    </body>
</html>