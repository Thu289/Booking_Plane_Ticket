
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Update Account</title>
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
                    <c:if test="${role==0}">
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="ManageAcc">Manage accounts</a>
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="ManageArticles">Manage articles</a>
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="UpdateProfile">Update profile</a>
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="LogOut">Log out</a>
                    </c:if>
                    <c:if test="${role==1}">
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Home">Home</a>
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="MyArticle">My article</a>
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Ticket">Ticket</a>
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="MyCart">My cart of ticket</a>            
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="ListOrder">List order</a>                 
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="UpdateProfile">Update profile</a>
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="LogOut">Log out</a>
                    </c:if>
                    <c:if test="${role==2}">
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="MyTicket">My ticket</a>
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="UpdateProfile">Update profile</a>
                        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="LogOut">Log out</a>
                    </c:if>
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
                        <c:if test="${demo!=null}">
                            <h1>${demo}</h1>
                        </c:if>
                        <form action="UpdateProfile" method="post">
                            <table>
                                <tr>
                                    <td>Name:</td>
                                    <td><input type="text" name="name" value="${accUpd.getUsername()}"></td>
                                </tr>
                                <tr>
                                    <td>Phone:</td>
                                    <td><input type="tel" name="phone" value="${accUpd.getPhone()}"></td>
                                </tr>
                                <tr>
                                    <td>Email:</td>
                                    <td><input type="text" name="email" value="${accUpd.getEmail()}"></td>
                                </tr>
                                <tr>
                                    <td>Address:</td>
                                    <td><input type="text" name="add" value="${accUpd.getAddress()}"></td>
                                </tr>
                                <tr>
                                    <td>Role:</td>
                                    <td>${accUpd.getRole()}</td>
                                </tr>
                                <tr>
                                    <td>Gender:</td>
                                    <td>
                                        <input type="radio" name="gender" value="1"
                                               <c:if test="${accUpd.isGender()==true}">checked </c:if>
                                                   >Male
                                               <input type="radio" name="gender" value="0"
                                               <c:if test="${accUpd.isGender()==true}">checked </c:if>
                                                   >Female
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Date of birth:</td>
                                        <td><input type="date" name="dob" value="${Date.parse(accUpd.getDob().toString())}"></td>
                                </tr>
                                <tr>
                                    <td>Status:</td>
                                    <td>
                                        <input type="radio" name="status" value="act" 
                                               <c:if test="${accUpd.isStatus()==true}" > checked</c:if> >Active
                                               <input type="radio" name="status" value="ina"
                                               <c:if test="${accUpd.isStatus()!=true}" > checked</c:if>>Inactive
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><input hidden name="idUpd" value="${accUpd.getId()}"></td>
                                    <td><input type="submit" value="Update"></td>
                                </tr>
                            </table><br><br><br>
                        </form>
                        <c:if test="${err!=null}">
                            <br><h3>${err}</h3><br>
                        </c:if>
                        <h4>Change password</h4>
                        <form action="ChangePassword" method="post">
                            <table>
                                <tr>
                                    <td>Old Password</td>
                                    <td><input type="password" name="oPass"></td>
                                </tr>
                                <tr>
                                    <td>New Password</td>
                                    <td><input type="password" name="nPass"></td>
                                </tr>
                                <tr>
                                    <td>Re-enter new password</td>
                                    <td><input type="password" name="rPass"></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="Change"></td>
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





