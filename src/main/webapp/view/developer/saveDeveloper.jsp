<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Save Developer</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Developer parameters:</h2>
        <p>
        <c:if test="${mode == 0}">
            <form name="developerForm" method="post" action="create">
                Name: <input type="text" name="name"/> <br/>
                Age: <input type="numeric" name="age"/> <br/>
                Gender: <input type="text" name="gender"/> <br/>
                Salary: <input type="numeric" name="salary"/> <br/>
                Company ID: <input type="numeric" name="companyId"/> <br/>

                <input type="submit" value="Add developer"  class="button"/>
            </form>
        </c:if>
        <c:if test="${mode == 1}">
            <form name="developerForm" method="put" action="update">
                ID: <input readonly type="text" name="id" value=${developer.id} /> <br/>
                Name: <input type="text" name="name" value=${developer.name} /> <br/>
                Age: <input type="numeric" name="age" value=${developer.age} /> <br/>
                Gender: <input type="text" name="gender" value=${developer.gender} /> <br/>
                Salary: <input type="numeric" name="salary" value=${developer.salary} /> <br/>
                Company ID: <input type="numeric" name="companyId" value=${developer.company.id} /> <br/>

                <input type="submit" value="Update developer"  class="button"/>
            </form>
        </c:if>
        </p>
    </body>
</html>