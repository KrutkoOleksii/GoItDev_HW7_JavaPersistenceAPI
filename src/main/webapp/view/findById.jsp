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
        <h2>Find ${entity} by ID:</h2>
        <p>
        <form name=${entity}"FindForm" method="get" action="findById">
        <table>
            <tr>
                <th>Enter ${entity} ID:</th>
                <td><input type="numeric" name="id"/> <br/></td>
            </tr>
        </table>
        <input type="submit" value="Find ${entity}"  class="button"/>
        </form>
        </p>
        <p>${message}</p>
    </body>
</html>