<%-- 
    Document   : Forgot
    Created on : Jul 11, 2022, 9:41:38 AM
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
        <form action="Forgot" method="post" style="text-align: center">
            <table>
                <tr>
                    <td>Phone</td>
                    <td><input type="tel" name="phone"></td>
                </tr>
                <tr>
                    <td>Password (nearest)</td>
                    <td><input type="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Send"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
