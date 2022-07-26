<%-- 
    Document   : SearchArticleResult
    Created on : Jul 9, 2022, 6:49:13 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.account!=null}">
                <%@include file="UserNavBar.jsp" %>
            </c:when>
            <c:otherwise>
                <%@include file="MainNavBar.jsp" %>
            </c:otherwise>
        </c:choose>
        <form action="ArticlesPage" method="post">
            <%@include file="SearchArticle.jsp" %>
        </form><!-- comment -->
        <c:choose>
            <c:when test="${mess!=null}">
                <h2>${mess}</h2>
            </c:when>
            <c:otherwise>
                <table>
        <c:forEach items="${list}" var="art">
            <tr>
                <td><img src="${art.getImg()}" alt="${art.getTitle()}" width="600" height="400"/></td>
                <td>
                    <h3>${art.getTitle()}</h3>
                    <p>${art.getDiscription()}</p>
                    <h4><a href="ArticlesPage?id=${art.getId()}">View details</a></h4>
                    <h6>${art.getViews()}</h6>
                </td>
            </tr>
        </c:forEach>
    </table>
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
