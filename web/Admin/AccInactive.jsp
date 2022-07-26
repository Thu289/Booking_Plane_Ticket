<%-- 
    Document   : ListAcc
    Created on : Jul 4, 2022, 9:56:35 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, td, th{
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <%@include file="AdminNavBar.jsp" %>
        <a href="ManageAcc">View all account</a>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Role</th>
                    <th>Gender</th>
                    <th>Dob</th>
                    <th>Status</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${DAO.getAccount()}" var="acc">
                    <c:if test="${!acc.isStatus()}">
                    <tr>
                        <td>${acc.getUsername()}</td>
                        <td>${acc.getPhone()}</td>
                        <td>${acc.getEmail()}</td>
                        <td>${acc.getAddress()}</td>
                        <td>${acc.getRole()}</td>
                        <td>${acc.isGender()?"Male":"Female"}</td>
                        <td>${acc.getDob()}</td>
                        <td>${acc.isStatus()?"Active":"Inactive"}</td>
                        <td><a href="UpdateAcc?type=1&id=${acc.getId()}">${acc.isStatus()?"Inactive":"Active"}</a></td>
                        <td><a href="UpdateAcc?type=0&id=${acc.getId()}">Delete</a></td>
                    </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
