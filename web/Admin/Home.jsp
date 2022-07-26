<%-- 
    Document   : Home
    Created on : Jun 28, 2022, 9:28:50 AM
    Author     : Vostro 5502
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/Main/SearchArticle.jsp" %>
        <div style="float: left">
            <ul>
                <li style="display: block"><a href="Home.jsp">Home</li>
                <li style="display: block"><a href="../Admin_CensorAcc">Censor new account</a></li>
                <li style="display: block"><a href="../Admin.CensorArticle">Censor new article</a></li>
                <li style="display: block"><a href="../Admin.UpdateProfile">Update Profile</a></li>
            </ul>
        </div>
        <%@include file="/Main/Articles.jsp" %>
    </body>
</html>
