<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Save Project</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Project parameters:</h2>
        <p>
        <c:if test="${mode == 0}">
            <form name="projectForm" method="post" action="create">
                Name: <input type="text" name="name"/> <br/>
                Cost: <input type="numeric" name="cost"/> <br/>
                Start date: <input type="date" name="startDate" pattern = "yyyy-MM-dd"/> <br/>
                Company ID: <input type="numeric" name="companyId"/> <br/>
                Customer ID: <input type="numeric" name="customerId"/> <br/>

                <input type="submit" value="Add project"  class="button"/>
            </form>
        </c:if>
        <c:if test="${mode == 1}">
            <form name="projectForm" method="put" action="update">
                ID: <input readonly type="text" name="id" value=${project.id} /> <br/>
                Name: <input type="text" name="name" value=${project.name} /> <br/>
                Cost: <input type="numeric" name="cost" value=${project.cost} /> <br/>
                <%--
                Start date: <input type="date" name="startDate" pattern = "yyyy-MM-dd" value=${project.startDate} /> <br/>
                --%>
                Start date: <input type="date" name="startDate" value=${project.startDate} /> <br/>
                Company ID: <input type="numeric" name="companyId" value=${project.company.id} /> <br/>
                Customer ID: <input type="numeric" name="customerId" value=${project.customer.id} /> <br/>

                <input type="submit" value="Update project"  class="button"/>
            </form>
        </c:if>
        </p>
    </body>
</html>