<%-- 
    Document   : cart
    Created on : 01-03-2023, 15:57:28
    Author     : Trình Vĩnh Phat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <!-- Đính kèm thư viện Font Awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            />
        <link href="css/style.css" rel="stylesheet" />
        <link href="css/shopping.css" rel="stylesheet" />
        <link href="css/pagination.css" rel="stylesheet" />

        <style>
            #detail-content {
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
        <div class="container" id="detail-content">
            <div class="row" style="margin-top: 20px">
                <div class="col-4" style="display: flex;flex-direction: column;text-align: center;gap: 20px;">
                    <h1 style="overflow: hidden;width: 100%;height: 50px;">Message to shop</h1>
                    <textarea style="width: 100%; min-height: 300px;padding: 2px"></textarea>
                    <a href="cart">Back to cart</a>
                    <a onclick="createOrder()">Complete</a>

                </div>
                <div class="col-8" style="margin-top: 20px">
                    <table class="table-bordered">
                        <tr>
                            <th>STT</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                        <c:forEach items="${listItem}" var="item">
                            <tr>

                                <td>${item.plant.getPID()}</td>
                                <td>
                                    <img
                                        src="resources/images/${item.plant.imgPath}"
                                        alt=""
                                        style="height: 100px; width: 100px"
                                        />
                                </td>
                                <td style="width: 500px">${item.plant.PName}</td>
                                <td>${item.plant.price}</td>
                                <td>
                                    ${item.cartItem.quantity}
                                </td>
                                <td>${item.cartItem.quantity * item.plant.price}</td>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>

        <form action="cart" method="post" id="item-form" style="display: none;">
            <input type="hidden" name="id" id="item-form-id">
            <input type="hidden" name="amount" id="item-form-amount">
            <input type="hidden" name="action" id="item-form-action">
        </form> 
        <form action="checkout" method="post" id="form-createOrder" style="display: none">
            <input type="hidden" name="action" value="BUY FROM CART">
        </form>
        <!--footer-->
        <%@ include file="/WEB-INF/views/client/common/footer.jsp" %>
        <!--end footer-->
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
            function createOrder() {
                $("#form-createOrder").submit();
            }
        </script>
    </body>
</html>

