<%-- 
    Document   : Confirm
    Created on : Jun 28, 2022, 10:32:58 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${confirm}</h1>
        <form action="Confirm_Phone" method="post">
            <input type="number" name="code"><br><br>
            <input type="submit" value="Confirm">
        </form>
    </body>
</html>
