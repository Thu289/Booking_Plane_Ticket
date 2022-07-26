<%-- 
    Document   : Ticket
    Created on : Jul 3, 2022, 1:45:33 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="Home">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="Home">Home</a></li>
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="MyArticle">My article</a></li>
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="Ticket">Ticket</a></li>
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="MyCart">My cart of ticket</a></li>
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="ListOrder">List order</a></li>
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="LogOut">Log out</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Page Header-->
        <header class="masthead" style="background-image: url('assets/img/ce-travel.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>Let's go</h1>
                            <span class="subheading">Open your world</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <!-- Main Content-->
        <div class="container px-4 px-lg-5">
            <div class="row gx-4 gx-lg-5 justify-content-center">
                <div class="col-md-10 col-lg-8 col-xl-7">
                    <form action="ArticlesPage" method="post" style="text-align: center;">
                        <%@include file="SearchArticle.jsp" %>
                    </form>
                    <c:forEach items="${DAO.getListTicket()}" var="tick">
                        <!-- Post preview-->
                        <div class="post-preview">
                            <table style="border: solid 1px black">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>Time:</td>
                                    <td>${tick.getBookTime()}</td>
                                </tr>
                                <tr>
                                    <td>Departure:</td>
                                    <td>${tick.getDeparture()}</td>
                                    <td></td>
                                    <td>Destination:</td>
                                    <td>${tick.getDestination()}</td>
                                </tr>
                                <tr>
                                    <td>Price:</td>
                                    <td>${tick.getPrice()}</td>
                                    <td></td>
                                    <td>License plate:</td>
                                    <td>${tick.getLicense_plate()}</td>
                                </tr>
                                <tr>
                                    <td>Firm name:</td>
                                    <td>${tick.getFirmName()}</td>
                                    <td></td>
                                    <td>Remain site:</td>
                                    <td>${tick.getRemainSite()}</td>
                                </tr>
                                <tr>
                                    <td><a href="AddToCart?id=${tick.getId()}">Add to cart</a></td>
                                </tr>
                            </table>
                        </div>
                        <!-- Divider-->
                        <hr class="my-4" />
                    </c:forEach>


                    <!-- Pager-->
                </div>
            </div>
        </div>
        <!-- Footer-->
        <footer class="border-top">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <ul class="list-inline text-center">
                            <li class="list-inline-item">
                                <a href="#!">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                                    </span>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a href="#!">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                                    </span>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a href="#!">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                                    </span>
                                </a>
                            </li>
                        </ul>
                        <div class="small text-center text-muted fst-italic">Copyright &copy; Your Website 2022</div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    

