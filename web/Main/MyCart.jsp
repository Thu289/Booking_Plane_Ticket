<%-- 
    Document   : MyCart
    Created on : Jul 15, 2022, 10:02:24 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>My cart</title>
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
                        <c:if test="${mes!=null}">
                            <h2>${mes}</h2>
                        </c:if> 

                        <c:if test="${order!=null}">
                            <h3>${order}</h3> <br><br><br>
                        </c:if>

                        <c:choose>
                            <c:when test="${mess!=null}">
                                <h2>Cart is empty</h2>
                            </c:when>
                            <c:otherwise>

                                <table>
                                    <thead>
                                        <tr>
                                            <td>Departure</td>
                                            <td>Destination</td>
                                            <td>Price</td>
                                            <td>Quantity</td>
                                            <td>License-plate</td>
                                            <td>Firm</td>
                                            <td>Remain site</td>
                                            <td></td>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach items="${cart}" var="c">
                                            <tr><form action="UpdateCartQuantity" method="post">
                                            <td>${c.getT().getDeparture()}</td>
                                            <td>${c.getT().getDestination()}</td>
                                            <td>${c.getT().getPrice()}</td>
                                            <td>
                                                <input onchange="this.form.submit()" type="number" name="quantity" value="${c.getQuantity()}">
                                                <input type="hidden" name="cId" value="${c.getId()}">
                                            </td>
                                            <td>${c.getT().getLicense_plate()}</td>
                                            <td>${c.getT().getFirmName()}</td>
                                            <td>${c.getT().getRemainSite()}</td>
                                            <td><a href="Buy?id=${c.getId()}">Buy now</a></td>
                                        </form></tr>
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

