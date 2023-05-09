<%-- 
    Document   : PlantForm
    Created on : 22-03-2023, 00:44:55
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
                line-height: 36px;
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
            <%@ include file="/WEB-INF/views/admin/common/header.jsp" %>
        </header>
        <main>
            <div class="container-fluid" id="content-con">
                <div class="row flex-nowrap">
                    <%@ include file="/WEB-INF/views/admin/common/sidebar.jsp" %>
                    <div class="col py-3">
                        <form style="display: flex;flex-direction: column;gap: 20px;" action="admin-PlantManaging" method="post" enctype="multipart/form-data">
                            <div id="form-item">
                                <label for="">Name</label><input name="name" value="${plant.getPName()}" required="" type="text">
                            </div>
                            <div id="form-item">
                                <label for="">Category</label>
                                <select name="category">
                                    <c:forEach items="${listCategory}" var="item">
                                        <c:if test="${plant.getCateID() == item.getCateID()}">
                                            <option value="${item.getCateID()}" selected="">${item.getCateName()}</option>
                                        </c:if>
                                        <c:if test="${plant.getCateID() != item.getCateID()}">
                                            <option value="${item.getCateID()}">${item.getCateName()}</option>
                                        </c:if>
                                       
                                    </c:forEach>

                                </select>
                            </div>
                            <div id="form-item">
                                <label for="">Price</label><input value="${plant.getPrice()}" name="price" required="" type="number">
                            </div>
                            <div id="form-item">
                                <label for="">Description</label><textarea style="width: 30%;height: 300px;" name="description" type="text" required="">${plant.getDescription()}</textarea>
                            </div>
                            <div id="form-item">
                                <label for="">file</label><input name="file" type="file" value="resources/images/${plant.getImgPath()}" accept="image/png" required="">
                            </div>
                            <c:if test="${action == 1}">
                                <button class="btn btn-primary btn-icon-append" type="submit" name="action" value="add">ADD</button>
                            </c:if>
                            <c:if test="${action == 2}">
                                <button class="btn btn-primary btn-icon-append" type="submit" name="action" value="edit">edit</button>
                                <input type="hidden" name="id" value="${plant.getPID()}">
                            </c:if>
                        </form>
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

