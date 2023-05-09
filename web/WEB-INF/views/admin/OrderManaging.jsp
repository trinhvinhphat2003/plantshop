<%-- 
    Document   : PlantManaging
    Created on : 21-03-2023, 23:05:27
    Author     : Trình Vĩnh Phat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous"
            />

        <link
            rel="stylesheet"
            href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css"
            />

        <style>
            #content-con .nav-item {

            }
            #content-con .nav-item:hover {
                background-color: green;
            }
            #content-con .nav-item.active {
                background-color: green;
            }
        </style>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
            integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
        ></script>
        <script
            defer
            src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"
        ></script>
        <script
            defer
            src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"
        ></script>

        <script defer>
            $(document).ready(function () {
                $("#example").DataTable();
            });
        </script>
    </head>

    <body>
        <header>
            <!-- place navbar here -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button
                        class="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                        >
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="display: flex;justify-content: flex-end;width: 100%;">
                            <li class="nav-item dropdown">
                                <a
                                    class="nav-link dropdown-toggle"
                                    href="#"
                                    id="navbarDropdown"
                                    role="button"
                                    data-bs-toggle="dropdown"
                                    aria-expanded="false"
                                    >
                                    ${sessionScope.User.getFullname()}
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="logout">Log Out</a></li>

                                </ul>
                            </li>
                        </ul>
                        <!-- <form class="d-flex">
                          <input
                            class="form-control me-2"
                            type="search"
                            placeholder="Search"
                            aria-label="Search"
                          />
                          <button class="btn btn-outline-success" type="submit">
                            Search
                          </button>
                        </form> -->
                    </div>
                </div>
            </nav>
        </header>
        <main>
            <div class="container-fluid" id="content-con">
                <div class="row flex-nowrap">
                    <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
                        <div
                            class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100"
                            >
                            <a
                                href="/"
                                class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none"
                                >
                                <span class="fs-5 d-none d-sm-inline">Menu</span>
                            </a>
                            <ul
                                class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
                                id="menu"
                                style="width: 100%"
                                >
                                <li class="nav-item" style="width: 100%; border-radius: 5px">
                                    <a
                                        href="admin-PlantManaging"
                                        style="color: white"
                                        class="nav-link align-middle px-0"
                                        >
                                        <i class="fs-4 bi-house"></i>
                                        <span class="ms-1 d-none d-sm-inline">Plant Managing</span>
                                    </a>
                                </li>
                                <li class="nav-item" style="width: 100%; border-radius: 5px">
                                    <a
                                        href="admin-AccountManaging"
                                        style="color: white"
                                        class="nav-link align-middle px-0"
                                        >
                                        <i class="fs-4 bi-house"></i>
                                        <span class="ms-1 d-none d-sm-inline">Account Managing</span>
                                    </a>
                                </li>
                                <li class="nav-item active" style="width: 100%; border-radius: 5px">
                                    <a
                                        href="admin-OrderManaging"
                                        style="color: white"
                                        class="nav-link align-middle px-0"
                                        >
                                        <i class="fs-4 bi-house"></i>
                                        <span class="ms-1 d-none d-sm-inline">Order managing</span>
                                    </a>
                                </li>
                                <li class="nav-item" style="width: 100%; border-radius: 5px">
                                    <a
                                        href="admin-CategoryManaging"
                                        style="color: white"
                                        class="nav-link align-middle px-0"
                                        >
                                        <i class="fs-4 bi-house"></i>
                                        <span class="ms-1 d-none d-sm-inline">Category Managing</span>
                                    </a>
                                </li>
                            </ul>
                            <hr />
                        </div>
                    </div>
                    <div class="col py-3">
                        <form action="admin-OrderManaging" method="get" class="row" style="display: flex;justify-content: flex-end;margin-right: 20px;margin-bottom: 20px">
                            <button type="submit" class="btn btn-primary btn-icon-append" style="width: 10%;margin-bottom: 20px;">Filter</button><label for="from">from</label><input type="date" name="from" id="from"><label for="to">to</label><input type="date" name="to" id="to">
                        </form>
                        <table id="example" class="table table-striped" style="width: 100%">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Order Date</th>
                                    <th>Ship Date</th>
                                    <th>Status</th>
                                    <th>AccID</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listItem}" var="item">
                                    <tr>
                                        <td >${item.getOrderID()}</td>
                                        <td >${item.getOrdDate()}</td>
                                        <td>${item.getShipdate()}</td>


                                        <c:if test="${item.getStatus() == 1}">
                                            <td>processing</td>
                                        </c:if>
                                        <c:if test="${item.getStatus() == 2}">
                                            <td>completed</td>
                                        </c:if>
                                        <c:if test="${item.getStatus() == 3}">
                                            <td>cancel</td>
                                        </c:if>


                                        <td>
                                            ${item.getAccID()}
                                        </td>
                                    </tr> 
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>ID</th>
                                    <th>Order Date</th>
                                    <th>Ship Date</th>
                                    <th>Status</th>
                                    <th>AccID</th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <!-- place footer here -->
        </footer>
        <!-- Bootstrap JavaScript Libraries -->
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"
        ></script>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
            crossorigin="anonymous"
        ></script>
    </body>
</html>

