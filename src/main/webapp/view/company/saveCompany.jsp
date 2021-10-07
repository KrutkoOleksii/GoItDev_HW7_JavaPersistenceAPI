<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Save Company</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Company parameters:</h2>
        <p>
        <c:if test="${mode == 0}">
            <form name="companySaveForm" method="post" action="create">
                Name: <input type="text" name="name"/> <br/>
                Code: <input type="text" name="code"/> <br/>

                <input type="submit" value="Add company" class="button"/>
            </form>
        </c:if>
        <c:if test="${mode == 1}">
            <form name="companyUpdateForm" method="put" action="update">
                ID: <input readonly type="text" name="id" value=${company.id} /> <br/>
                New name: <input type="text" name="name" value=${company.name} /> <br/>
                New code: <input type="text" name="code" value=${company.code} /> <br/>

                <input type="submit" value="Update company" class="button"/>
            </form>
        </c:if>
        </p>
    </body>
</html>