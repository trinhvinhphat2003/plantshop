<%-- 
    Document   : header
    Created on : 01-03-2023, 10:56:57
    Author     : Trình Vĩnh Phat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            * {
                margin: 0px;
                padding: 0px;
                box-sizing: border-box;
                overflow-x: hidden;
            }

            #logo {
                border: 2px solid black;
                border-radius: 10px;
            }

            nav {
                border-bottom: 0.5px solid black;
            }

            #logo-text {
                color: black;
            }

            #home_content {
                background-image: url('https://hips.hearstapps.com/hmg-prod/images/plant-guide-1663941701.jpg?resize=1200:*');
                background-repeat: no-repeat;
                background-size: 100% 100%;
                height: 70vh;
            }

            .nav-item {
                margin-left: 30px;
                margin-right: 30px;
                color: black !important;
                border-bottom: 2px solid black; border-radius: 0px
            }

            .nav-item:hover {
                border-bottom: 2px solid blue;
            }

            footer {
                height: 150px;
                display: block;
                background-color: black;
            }

            .link-icon button {
                padding-left: 10px;
            }

            .link-icon button span {
                position: relative;
                top: 2px;
                right: 3px;
            }

            main {
                height: 90vh;
                display: flex;
                justify-content: center;
                align-items: center;
                background-image: url('https://hips.hearstapps.com/hmg-prod/images/plant-guide-1663941701.jpg?resize=1200:*');
                background-repeat: no-repeat;
                background-size: 100% 100%;
            }

            .form {
                border: 2px solid black;
                width: 400px;
                padding: 40px;
                border-radius: 10px;
                background-color: white;
                border: none;
            }

            .form h1 {
                text-align: center;
                overflow-y: hidden;
                margin: 0px;
            }

            .form-control-common {
                position: relative;
                width: 100%;
                margin-top: 40px;
                overflow-y: hidden;
            }

            .form-control-common input {
                width: 100%;
                height: 40px;
                border: none;
                outline: none;
                border-bottom: 1px solid black;
            }

            .form-control-common span {
                position: absolute;
                display: block;
                height: 4px;
                background-color: aqua;
                width: 0%;
                left: 0px;
                top: 38px;
                transition: 0.3s;
            }

            .form-control-common input:focus ~ span {
                width: 100%;
            }

            .form-control-common.error small {
                color: red;
            }

            .form-control-common.error input {
                border-bottom: 3px solid red;
            }

            #login-button {
                margin-top: 20px;
                width: 100%;
                height: 50px;
                border-radius: 25px;
                border: none;
                outline: none;
                background-color: rgb(35, 129, 253);
                color: white;
                font-weight: bold;
                transition: 0.5s ;
            }

            #login-button:hover {
                background-color: blue;
            }

            #login-button:active {
                background-color: rgb(35, 129, 253);
            }

            .sign-up-link {
                margin-top: 40px;
                text-align: center;
            }

            .sign-up-link a {
                text-decoration: none;
            }

            .form-control-common.success input{
                background-color: rgb(47, 234, 255);
            }

            #register-form {
                display: none;
            }

            #remember-me-container {
                margin-top: 20px;
                display: flex;
                justify-content: flex-end;
                align-items: center;
            }

            #remember-me-container input {
                width: 20px;
                height: 20px;
                margin-right: 5px;
            }
            .footer-content {
                color: white;
                padding: 10px;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                overflow: hidden;
            }
            .footer-content h5 {
                margin: 0px;
                overflow: hidden;
            }

            #sub-menu-user {
                height: fit-content;
                width: 190px;
                background-color: white;
                position: absolute;
                z-index: 999;
                right: 5px;
                top: 70px;
                display: none;
                padding: 10px;
                box-shadow: 0 6px 12px 0 rgb(0 0 0 / 18%);
                border-radius: 5px;
            }

            #user-table:hover #sub-menu-user {
                display: block;
            }

            #sub-menu-user div {
                background-color: red;
                padding: 5px;
                border-radius: 5px;
                text-align: center;
                color: white;
            }

            #sub-menu-user div:not(:first-child) {
                margin-top: 10px;
            }
            #sub-menu-user a {
                text-decoration: none;
                color: white;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="home.html" style="margin-left: 50px">
                    <img
                        src="resources/images/logo2.png"
                        style="width: 60px; height: 60px"
                        alt="logo"
                        id="logo"
                        />
                    <span class="text-uppercase fw-lighter ms-0" id="logo-text"
                          >plant shop</span
                    >
                </a>
                <div class="nav">
                    <ul class="navbar-nav mx-auto text-center text-uppercase">
                        <li class="nav-item">
                            <a class="nav-link" href="home" style="color: black">home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="shopping" style="color: black">shopping</a>
                        </li>
                    </ul>
                </div>
                <div class="link-icon" style="margin-right: 50px;position: relative;overflow: hidden;display: flex;">
                    <a href="cart"><button style="border-radius: 5px; margin-right: 20px;">
                            <i class="fas fa-shopping-cart"></i>
                            <span class="ps-1" style="display: inline-block; width: 30px;color: red;"
                                >
                                <c:if test="${sessionScope.User == null}">
                                    0
                                </c:if>
                                 <c:if test="${sessionScope.User != null}">
                                    ${cartCountItem}
                                </c:if>  
                            </span
                            >
                        </button></a>
                    <div id="user-table" style="display: inline-block;border: 2px solid black;padding: 10px;border-radius: 5px;position: relative;">
                        <img src="resources/images/logo2.png" style="height: 30px;width: 30px;border-radius: 25px;margin-right: 10px;" alt="">
                        <span><a href="#">
                                <c:if test="${sessionScope.User != null}">
                                    ${sessionScope.User.getFullname()}
                                </c:if>
                                <c:if test="${sessionScope.User == null}">
                                    guest
                                </c:if>
                            </a></span>
                    </div>
                </div>
            </div>
        </nav>
        <div id="sub-menu-user">
            <c:if test="${sessionScope.User == null}">
                <div><a href="login">sign in</a></div>
                <div><a href="register">sign up</a></div>

            </c:if>
            <c:if test="${sessionScope.User != null}">
                <div><a href="profile">your profile</a></div>
                <div><a href="logout">log out</a></div>
                <div><a href="order">your order</a></div>
            </c:if>
            <div><a href="cart">your cart</a></div>

        </div>
    </body>
</html>
