
<%-- 
    Document   : Ticket
    Created on : Jul 3, 2022, 1:45:33 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Travel</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />

    </head>
    <body>


        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="Home">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <c:choose>
                        <c:when test="${sessionScope.account!=null}">
                            <ul class="navbar-nav ms-auto py-4 py-lg-0">
                                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="MyArticle">My article</a></li>
                                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="Ticket">Ticket</a></li>
                                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="MyCart">My cart of ticket</a></li>
                                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="ListOrder">List order</a></li>
                                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="UpdateProfile">Update profile</a></li>
                                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="LogOut">Log out</a></li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul class="navbar-nav ms-auto py-4 py-lg-0">
                                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="Login">Log in</a></li>
                                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="SignUp">Sign up</a></li>
                                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="Ticket">Ticket</a></li>
                            </ul>
                        </c:otherwise>
                    </c:choose>
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
                    <c:forEach items="${DAO.getArticles()}" var="art">
                        <c:if test="${art.getId()==articleId}">
                            <img src="${art.getImg()}" alt="${art.getTitle()}"/>
                            <h2>${art.getTitle()}</h2><br>
                            <p style="float: left">${art.getDateWritten()}</p><br>
                            <h5>${art.getDiscription()}</h5><br>
                            <p style="float: left">${art.getAuthorName()}</p><br>
                            <p style="float: left">Key word: ${art.getKeyword()}</p><br>
                            <p>Views: ${art.getViews()}</p><br>
                        </c:if>
                    </c:forEach>


                    <c:forEach items="${DAO.getListComment(articleId)}" var="com">
                        <br><h3>Post by: ${com.getAuthor()}</h3>
                        <p>${com.getDate()}, ${com.getStar()}Stars</p>
                        <p>${com.getDescription()}</p>
                        <a href="UpdateComment?type=2&id=${com.getId()}">Reply</a>
                        <c:if test="${com.getAuthorId()==accId}">
                            <a href="UpdateComment?type=1&id=${com.getId()}">Edit</a>
                            <a href="UpdateComment?type=0&id=${com.getId()}">Delete</a>
                        </c:if>
                        <c:if test="${comRep==com.getId()}">
                            <form action="Comment" method="post">
                                Comment reply ${com.getAuthor()}: <textarea name="comment"></textarea><br>
                                Star: 0<input type="range" name="star" min="0" max="5">5
                                <input type="submit" value="Send">
                            </form>
                        </c:if>    
                        
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




    </body>
</html>


