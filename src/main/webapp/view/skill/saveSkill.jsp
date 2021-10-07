<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Save Skill</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Skill parameters:</h2>
        <p>
        <c:if test="${mode == 0}">
            <form name="skillForm" method="post" action="create">
                Name (Technology): <input type="text" name="name"/> <br/>
                Level: <input type="text" name="level"/> <br/>

                <input type="submit" value="Add skill"  class="button"/>
            </form>
        </c:if>
        <c:if test="${mode == 1}">
            <form name="skillForm" method="put" action="update">
                ID: <input readonly type="text" name="id" value=${skill.id} /> <br/>
                Name (Technology): <input type="text" name="name" value=${skill.name} /> <br/>
                Level: <input type="text" name="level" value=${skill.skillLevel} /> <br/>

                <input type="submit" value="Update skill"  class="button"/>
            </form>
        </c:if>
        </p>
    </body>
</html>