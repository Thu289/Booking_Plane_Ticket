
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
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="MyTicket">My ticket</a>
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
                        <form action="AddTicket" method="post">
                            <table>
                                <tr>
                                    <td>Date</td>
                                    <td><input type="datetime-local" name="time"></td>
                                </tr>
                                <tr>
                                    <td>Departure:</td>
                                    <td><input type="text" name="dep"></td>
                                </tr>
                                <tr>
                                    <td>Destination</td>
                                    <td><input type="text" name="des"></td>
                                </tr>
                                <tr>
                                    <td>Price</td>
                                    <td><input type="number" name="price"></td>
                                </tr>
                                <tr>
                                    <td>License plate</td>
                                    <td><select name="license">
                                            <c:forEach items="${listLP}" var="lp">
                                                <option value="${lp.getId()}">${lp.getName()}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="Add"></td>
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







