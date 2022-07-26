<%-- 
    Document   : MainBoard
    Created on : Jun 6, 2022, 9:58:22 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Log in</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
    
        <div style="width: 40%; margin: auto; border: 1px solid #ccc; padding: 1rem;" class="mt-5">
            <h3>Login</h3>
            <form action="Login" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Email address</label>
                    <input type="text" class="form-control" id="username" name="phone" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <h3 class="text-danger">${errPhone}</h3>
                <button type="submit" class="d-flex btn btn-primary">Login</button>
                <a class="small" href="Forgot">Forgot Password?</a>
                <div class="card-footer text-center py-3 mt-3">
                    <div class="small"><a href="SignUp">Need an account? Sign up!</a></div>
                </div>
            </form>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>

    </body>
</html>
