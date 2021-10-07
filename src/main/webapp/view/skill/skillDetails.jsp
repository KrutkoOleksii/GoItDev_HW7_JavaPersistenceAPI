<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Skill</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Skill details</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
            <th>ID</th>
            <td><c:out value="${skill.id}"/></td>
        </tr>
        <tr>
            <th>Name (Technology)</th>
            <td><c:out value="${skill.name}"/></td>
        </tr>
        <tr>
            <th>Level</th>
            <td><c:out value="${skill.skillLevel}"/></td>
        </tr>
        </table>
        </p>
    </body>
</html>