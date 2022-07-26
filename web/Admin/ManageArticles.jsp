

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
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="ManageAcc">Manage accounts</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="ManageArticles">Manage articles</a>
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
                            <thead>
                                <tr>
                                    <td>Id</td>
                                    <td>Title</td>
                                    <td>Description</td>
                                    <td>Author name</td>
                                    <td>Date</td>
                                    <td>Key word</td>
                                    <td>Status</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${DAO.getArticles()}" var="art">
                                    <tr>
                                        <td>${art.getId()}</td>
                                        <td>${art.getTitle()}</td>
                                        <td><a href="ArticlesPage?id=${art.getId()}">${art.getTitle()}</a></td>
                                        <td><a href="Admin_CensorAcc?id=${art.getAuthor()}">${art.getAuthorName()}</a></td>
                                        <td>${art.getDateWritten()}</td>
                                        <td>${art.getKeyword()}</td>
                                        <td>${art.isStatus()?"Active":"Inactive"}</td>
                                        <td><a href="UpdateArticle?type=1&id=${art.getId()}">${art.isStatus()?"Inactive":"Active"}</a></td>
                                        <td><a href="UpdateArticle?type=0&id=${art.getId()}">Delete</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        
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




