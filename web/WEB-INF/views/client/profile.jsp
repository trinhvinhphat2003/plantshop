<%-- 
    Document   : PlantDetail
    Created on : 01-03-2023, 16:31:45
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
                width: 100%;
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
        </style>

        <link rel="stylesheet" href="css/plan.css" />
    </head>

    <body>
        <!-- nav -->
        <%@ include file="/WEB-INF/views/client/common/header.jsp" %>
        <!--end nav-->
        ${errorMsg}
        <form class="container" id="detail-content" style="" action="profile" method="post">
            <div class="row" style="">
                <div
                    style="
                    display: flex;
                    flex-direction: column;
                    gap: 20px;
                    margin: 0 auto;
                    margin-top: 100px;
                    "
                    class="col-6"
                    >
                    <input type="text" required="" placeholder="fullname" name="fullname" value="${sessionScope.User.getFullname()}"/>
                    <input type="text" placeholder="email" disabled value="${sessionScope.User.getEmail()}"/>
                    <input type="text" required="" placeholder="phone" name="phone" value="${sessionScope.User.getPhone()}" />
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <button
                    type="submit"
                    name="action"
                    value="change"
                    style="
                    background-color: red;
                    color: white;
                    padding: 5px;
                    border-radius: 5px;
                    height: 40px;
                    width: 70px;
                    margin: 0 auto;
                    "
                    >
                    Change
                </button>
            </div>
        </form>
        <!--footer-->
        <%@ include file="/WEB-INF/views/client/common/footer.jsp" %>
        <!--end footer-->
        <form id="form-checkout" action="checkout" method="get" style="display: none">
            <input type="hidden" name="action" value="BUY NOW">
            <input type="hidden" name="PID" id="checkoutpid" value="">
        </form>

        <form id="form-cart" action="cart" method="post" style="display: none">
            <input type="hidden" name="action" value="ADD TO CART">
            <input type="hidden" name="id" id="cartpid" value="">
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
            function BuyNowSubmit(PID) {
                $("#form-checkout #checkoutpid").val(PID);
                $("#form-checkout").submit();
            }
            function AddToCartSubmit(PID) {
                $("#form-cart #cartpid").val(PID);
                $("#form-cart").submit();
            }
        </script>
    </body>
</html>

