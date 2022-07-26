<%-- 
    Document   : MainBoard
    Created on : Jun 6, 2022, 11:00:54 AM
    Author     : Vostro 5502
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"  href="Main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
            <li style="display: inline"><a href="MainBoard.jsp">Home</li>
            <li style="float: right; display: inline"><a href="../Login/Login.jsp">Log in</a></li>
            <li style="float: right; display: inline"><a href="../Signup/Signup.jsp">Sign up</a></li>
        </ul>
        <form action="" method="get">
            <%@include file="Search.jsp" %>
        </form>
    </body>
</html>
