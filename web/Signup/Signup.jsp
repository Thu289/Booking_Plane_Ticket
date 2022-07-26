<%-- 
    Document   : Signup
    Created on : Jun 6, 2022, 11:22:02 AM
    Author     : Vostro 5502
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <style>
            @media (min-width: 1025px) {
                .h-custom {
                    height: 100vh !important;
                }
            }
        </style>
    </head>
    <body>

        <h1>${cooke}</h1>
        <h1>${here}</h1>

        <section class="h-100 h-custom">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-8 col-xl-6">
                        <div class="card rounded-3">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                                 class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                                 alt="Sample photo">
                            <div class="card-body p-4 p-md-5">
                                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Registration Info</h3>

                                <form class="px-md-2" action="SignUp" method="post">

                                    <div class="form-outline mb-4">
                                        <input type="text" id="form3Example1q" class="form-control" name="username" value="${acc.getUsername()}"/>
                                        <label class="form-label" for="form3Example1q">Name</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" id="form3Example1q" class="form-control" name="password" value="${acc.getPassword()}"/>
                                        <label class="form-label" for="form3Example1q">Password</label>
                                    </div>
                                        
                                    <div class="form-outline mb-4">
                                        <input type="password" id="form3Example1q" class="form-control" name="re-password" value="${acc.getPassword()}"/>
                                        <label class="form-label" for="form3Example1q">Re-enter password</label>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">

                                            <div class="form-outline datepicker">
                                                <input type="date" name="dob" value="${acc.getDob()}" class="form-control" id="exampleDatepicker1" />
                                                <label for="exampleDatepicker1" class="form-label">Select date of birth</label>
                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4">

                                            <select class="select" name="gender">
                                                <option value="female">Female</option>
                                                <option value="male">Male</option>
                                            </select>

                                        </div>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="number" name="phone" value="${acc.getPhone()}" id="form3Example1q" class="form-control"/>
                                        <label class="form-label" for="form3Example1q">Phone number</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="email" name="email" value="${acc.getEmail()}" id="form3Example1q" class="form-control"/>
                                        <label class="form-label" for="form3Example1q">Email</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" name="address" value="${acc.getAddress()}" id="form3Example1q" class="form-control"/>
                                        <label class="form-label" for="form3Example1q">Address</label>
                                    </div>

                                    <div class="mb-4">

                                        <select class="select" name="role">
                                            <option value="admin">Admin</option>
                                            <option value="user">User</option>
                                            <option value="supplier">Supplier</option>
                                        </select>

                                    </div>

                                    <button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>


