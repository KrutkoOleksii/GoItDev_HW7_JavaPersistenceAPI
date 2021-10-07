<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Find ${entity}</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Find ${entity} by name:</h2>
        <p>
        <form name=${entity}"FindForm" method="get" action="findByName">
        <table>
            <tr>
                <th>Enter ${entity} name:</th>
                <td> <input type="text" name="name"/> <br/> </td>
            </tr>
        </table>
        <input type="submit" value="Find ${entity}"  class="button"/>
        </form>
        </p>
        <p>${message}</p>
    </body>
</html>