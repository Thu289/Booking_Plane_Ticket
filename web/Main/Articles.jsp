<%-- 
    Document   : Articles
    Created on : Jun 29, 2022, 11:07:28 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="text-align: center">
    <table>
        <c:forEach items="${DAO.getArticles()}" var="art" begin="${page.begin}" 
                   end="${page.end}">
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
    <form action="Home" method="post">
        <c:if test="${page.currentPage!=0}">
            <input type="submit" name="home" value="Home">
                <input type="submit" name="pre" value="pre">
        </c:if>
        <c:forEach begin="${page.pageStart}" end="${page.pageEnd}" var="i">
                <span><input type="submit" name="btn${i}" value="${i+1}"> </span>
        </c:forEach>
        <c:if test="${page.currentPage!=page.numberPage-1}">
            <input type="submit" name="next" value="Next"><!-- comment -->
                <input type="submit" name="end" value="End">
        </c:if>
            <input type="text" hidden name="currentPage" value="${page.currentPage}">
            <input type="text" hidden name="numberPage" value="${page.numberPage}">
    </form>
   
</div>