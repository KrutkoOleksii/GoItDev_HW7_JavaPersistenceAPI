<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete ${entity}</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Delete ${entity} by ID:</h2>
        <p>
        <form name=${entity}"DeleteForm" method="delete" action="delete">
        <table>
            <tr>
                <th>Enter ${entity} ID:</th>
                <td><input type="numeric" name="id"/> <br/></td>
            </tr>
        </table>
        <input type="submit" value="Delete ${entity}"  class="button"/>
        </form>
        </p>
        <p>${message}</p>
    </body>
</html>