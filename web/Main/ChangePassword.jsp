<%-- 
    Document   : ChangePassword
    Created on : Jul 11, 2022, 11:23:19 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${errPass}</h1>
        <form action="ChangePassword" method="post">
            <table>
                <tr>
                    <td>Old Password</td>
                    <td><input type="password" name="oldPass" value="${newPass}"></td>
                </tr>
                <tr>
                    <td>New password:</td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                    <td>Repeat new password</td>
                    <td><input type="password" name="rePass"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Change"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
