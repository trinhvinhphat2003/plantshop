<%-- 
    Document   : order
    Created on : 04-03-2023, 16:35:55
    Author     : Trình Vĩnh Phat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <!-- Đính kèm thư viện Font Awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            />
        <link href="css/style.css" rel="stylesheet" />
        <link href="css/shopping.css" rel="stylesheet" />
        <link href="css/pagination.css" rel="stylesheet" />

        <style>
            #details-content {
                min-height: 70vh;
            }

            * {
                margin: 0;
                padding: 0;
            }

            #detail-content .row a {
                text-align: center;
                text-decoration: none;
                background-color: red;
                color: white;
                height: 60px;
                font-size: 20px;
                line-height: 60px;
            }

            #detail-content .row a:first-child {
                border-right: 1px solid black;
            }
            #detail-content .row a:last-child {
                border-left: 1px solid black;
            }

            #img-detail img {
                height: 400px;
                padding: 0;
            }

            .action-product {
                padding: 0;
                box-shadow: 0 6px 12px 0 rgb(0 0 0 / 18%);
            }

            #select-area {
                padding-left: 40px;
                display: flex;
                flex-direction: column;
                gap: 40px;
            }

            #select-area span {
                box-shadow: 0 6px 12px 0 rgb(0 0 0 / 18%);
                width: 500px;
                min-height: 205px;
                padding: 10px;
                box-sizing: border-box;
            }
            .action-btn {
                cursor: pointer;
            }
            #detail-content {
            }

            table {
                border: 2px solod black;
            }

            tr,
            td {
                text-align: center;
            }

            th {
                padding: 10px;
            }

            tr td {
                padding: 10px;
            }
            footer {
                margin-top: 20px;
            }
        </style>

        <link rel="stylesheet" href="css/cart.css" />
    </head>

    <body>
        <!-- nav -->
        <%@ include file="/WEB-INF/views/client/common/header.jsp" %>
        <!--end nav-->
        <div class="container" id="details-content">
            <div class="row" style="margin-top: 20px">
                <h1 style="overflow: hidden; padding: 0; margin: 0; text-align: center">
                    YOUR ORDER
                </h1>
            </div>
            <div class="row" style="margin-top: 20px">
                <form style="display: flex;justify-content: flex-end;gap: 10px;" method="get" action="order">
                    <button style="padding: 5px;border-radius: 5px" name="action" value="filter">Filter</button><label for="from">from</label><input type="date" name="from" id="from"><label for="to">to</label><input type="date" name="to" id="to">
                </form>
            </div>
            <div class="row" style="margin-top: 20px">
                <table class="table-bordered">

                    <tr>
                        <th>ID</th>
                        <th>Order Date</th>
                        <th>Ship Date</th>
                        <th>Order Status</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${listItem}" var="item">
                        <tr>
                            <td>${item.getOrderID()}</td>
                            <td>${item.getOrdDate()}</td>
                            <td>${item.getShipdate()}</td>
                            <c:if test="${not empty item.getStatus()}">
                                <c:if test="${item.getStatus() == 1}">
                                    <td>processing</td>
                                </c:if>
                                <c:if test="${item.getStatus() == 2}">
                                    <td>completed</td>
                                </c:if>
                                <c:if test="${item.getStatus() == 3}">
                                    <td>cancel</td>
                                </c:if>
                            </c:if>
                            <c:if test="${empty item.getStatus()}">
                                <td>error</td>
                            </c:if>

                            <td>

                                <c:if test="${item.getStatus() == 1}">
                                    <a onclick="changeStatus(${item.getOrderID()})"><span
                                            style="
                                            height: 40px;
                                            width: 50px;
                                            background-color: blue;
                                            display: inline-block;
                                            color: white;
                                            border-radius: 10px;
                                            line-height: 40px;
                                            margin-right: 20px;
                                            cursor: pointer;
                                            "
                                            >cancel</span
                                        ></a>
                                    </c:if>
                                    <c:if test="${item.getStatus() == 3}">
                                        <a onclick="changeStatus(${item.getOrderID()})"><span
                                            style="
                                            height: 40px;
                                            width: 100px;
                                            background-color: blue;
                                            display: inline-block;
                                            color: white;
                                            border-radius: 10px;
                                            line-height: 40px;
                                            margin-right: 20px;
                                            cursor: pointer;
                                            overflow: hidden;
                                            "
                                            >re-order</span
                                        ></a>
                                    </c:if>
                                <a href="OrderDetail?id=${item.getOrderID()}"><span
                                        style="
                                        height: 40px;
                                        width: 50px;
                                        background-color: blue;
                                        display: inline-block;
                                        color: white;
                                        border-radius: 10px;
                                        line-height: 40px;
                                        margin-right: 20px;
                                        cursor: pointer;
                                        "
                                        >Detail</span
                                    ></a>
                            </td>
                        </tr> 
                    </c:forEach>

                </table>
            </div>
        </div>

        <!--footer-->
        <%@ include file="/WEB-INF/views/client/common/footer.jsp" %>
        <!--end footer-->
        
        <form id="form-changeStatus" method="post" action="order">
            <input name="id" id="id" value="">
            <input name="action" value="changeStatus">
        </form>
        
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
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"
            integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
        ></script>
        <script src="resources/client/js/script.js"></script>
        <script>
            function changeStatus(id) {
                $("#form-changeStatus #id").val(id);
                $("#form-changeStatus").submit();
            }
        </script>
    </body>
</html>

