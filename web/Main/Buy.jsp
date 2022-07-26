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
                        <table>
                            <tr>
                                <td>Departure:</td>
                                <td>${ticket.getT().getDeparture()}</td>
                            </tr>
                            <tr>
                                <td>Destination</td>
                                <td>${ticket.getT().getDestination()}</td>
                            </tr>
                            <tr>
                                <td>Price:</td>
                                <td>${ticket.getT().getPrice()}</td>
                            </tr>
                            <tr>
                                <td>Quantity:</td>
                                <td>${ticket.getQuantity()}</td>
                            </tr>
                            <tr>
                                <td>License-plate</td>
                                <td>${ticket.getT().getLicense_plate()}</td>
                            </tr>
                            <tr>
                                <td>Firm name:</td>
                                <td>${ticket.getT().getFirmName()}</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="hidden" name="cart" value="${ticket.getId()}"></td>
                            </tr>
                            <tr>
                                <td>Total Money:</td>
                                <td>${ticket.getT().getPrice() * ticket.getQuantity()}</td>
                            </tr>
                        </table>
                            <br><br><br>
                            <h2>Information:</h2>
                            <form action="Buy" method="post">
                                <table>
                                    <tr>
                                        <td>Name:</td>
                                        <td><input type="text" name="name" value="${sessionScope.account.getUsername()}"></td>
                                    </tr>
                                    <tr>
                                        <td>Phone:</td>
                                        <td><input type="number" name="phone" value="${sessionScope.account.getPhone()}"></td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td><input type="email" name="email" value="${sessionScope.account.getEmail()}"></td>
                                    </tr>
                                    <tr>
                                        <td><input type="hidden" name="cart" value="${ticket.getId()}"></td>
                                        <td><input type="submit" value="Buy"></td>
                                    </tr>
                                </table>
                            </form>    
                            
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

