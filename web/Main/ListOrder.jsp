

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>List order</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css1/styles.css" rel="stylesheet" />
        <style>
            table, td{
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light"></div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Home">Home</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="MyArticle">My article</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Ticket">Ticket</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="MyCart">My cart of ticket</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="ListOrder">List order</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="UpdateProfile">Update profile</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="LogOut">Log out</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle">Toggle Menu</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>

                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid">
                    <div>
                        <c:choose>
                            <c:when test="${mess!=null}">
                                <h2>${mess}</h2>
                            </c:when>
                            <c:otherwise>
                                <table>
                                    <thead>
                                        <tr>
                                            <td>Departure</td>
                                            <td>Destination</td>
                                            <td>Time</td>
                                            <td>Price</td>
                                            <td>Amount</td>
                                            <td>Firm name</td>
                                            <td>Total money</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${DAO.getListBookTicket(sessionScope.account.getId())}" var="b">
                                            <c:forEach items="${DAO.getListTicket()}" var="t">
                                                <c:if test="${t.getId()==b.getTicket()}">
                                                    <tr>
                                                        <td>${t.getDeparture()}</td>
                                                        <td>${t.getDestination()}</td>
                                                        <td>${b.getDate()}</td>
                                                        <td>${t.getPrice()}</td>
                                                        <td>${b.getAmount()}</td>
                                                        <td>${t.getFirmName()}</td>
                                                        <td>${t.getPrice()*b.getAmount()}</td>
                                                    </tr>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js1/scripts.js"></script>
    </body>
</html>

