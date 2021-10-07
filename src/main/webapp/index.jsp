<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Project management</title>
    <style>
            <%@include file="style.css" %>
    </style>
</head>
<body>

<c:import url="navibar.jsp"/>
<div><img src="https://www.matrixcubes.com/content/images/all/09/matrix-project-management-systems.png"
          alt="Project management system"/>
</div>
<%--
<!-- header -->
<div>
    <h2>Project management (homework #6 - Servlets)</h2>
</div>

<div>       <!-- content -->
    <table>
        <tr>
            <th>Company</th>
            <th>Customer</th>
            <th>Developer</th>
            <th>Project</th>
            <th>Skill</th>
        </tr>
        <tr>
            <td> <button onclick="location.href='/pm/company'">List company</button> </td>
            <td> <button onclick="location.href='/pm/customer'">List customer</button> </td>
            <td> <button onclick="location.href='/pm/developer'">List developer</button> </td>
            <td> <button onclick="location.href='/pm/project'">List project</button> </td>
            <td> <button onclick="location.href='/pm/skill'">List skill</button> </td>
        </tr>
        <tr>
            <td> <button onclick="location.href='/pm/company/add'">Add company</button> </td>
            <td> <button onclick="location.href='/pm/customer/add'">Add customer</button> </td>
            <td> <button onclick="location.href='/pm/developer/add'">Add developer</button> </td>
            <td> <button onclick="location.href='/pm/project/add'">Add project</button> </td>
            <td> <button onclick="location.href='/pm/skill/add'">Add skill</button> </td>
        </tr>
        <tr>
            <td> <button onclick="location.href='/pm/company/1'">Get company</button> </td>
            <td> <button onclick="location.href='/pm/customer/1'">Get customer</button> </td>
            <td> <button onclick="location.href='/pm/developer/1'">Get developer</button> </td>
            <td> <button onclick="location.href='/pm/project/1'">Get project</button> </td>
            <td> <button onclick="location.href='/pm/skill/1'">Get skill</button> </td>
        </tr>
        <tr>
            <td> <button onclick="location.href='/pm/company/update'">Update company</button> </td>
            <td> <button onclick="location.href='/pm/updateCustomer'">Update customer</button> </td>
            <td> <button onclick="location.href='/pm/updateDeveloper'">Update developer</button> </td>
            <td> <button onclick="location.href='/pm/updateProject'">Update project</button> </td>
            <td> <button onclick="location.href='/pm/updateSkill'">Update skill</button> </td>
        </tr>
        <tr>
            <td> <button onclick="location.href='/pm/deleteCompany'">Delete company</button> </td>
            <td> <button onclick="location.href='/pm/deleteCustomer'">Delete customer</button> </td>
            <td> <button onclick="location.href='/pm/deleteDeveloper'">Delete developer</button> </td>
            <td> <button onclick="location.href='/pm/deleteProject'">Delete project</button> </td>
            <td> <button onclick="location.href='/pm/deleteSkill'">Delete skill</button> </td>
        </tr>
    </table>
</div>
--%>
</body>
</html>