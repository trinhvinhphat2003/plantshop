<%-- 
    Document   : shopping
    Created on : 01-03-2023, 15:34:58
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
            .search-area {
                margin-top: 20px;
                margin-bottom: 20px;
                border: 2px solid black;
                padding: 20px 20px;
                display: flex;
                justify-content: center;
                align-items: center;
                position: relative;
                background-color: greenyellow;
                margin-top: 20px;
            }
            #search-input {
                width: 100%;
                height: 40px;
            }
            #search-input:focus {
                border: 2px solid blue;
            }
            #selection-search select {
                width: 100%;
                height: 40px;
            }
            #search-btn {
                display: flex;
                align-items: center;
                justify-content: center;
                border: 2px solid black;
                gap: 10px;
                height: 40px;
                background-color: rgb(0, 98, 255);
                color: white;
            }
            #search-btn label {
                position: relative;
                bottom: 1.5px;
            }
            #search-icon {
                color: white;
                position: relative;
                top: 2px;
            }
            .shopping-content {
                min-height: 90vh;
            }
            .sticky {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                z-index: 999;
                margin: 0;
            }
            .product-action-btn .row a {
                text-align: center;
                text-decoration: none;
                background-color: red;
                color: white;
                height: 50px;
                font-size: 20px;
                line-height: 50px;
            }

            .product-action-btn .row a:first-child {
                border-right: 1px solid black;
            }
            .product-action-btn .row a:last-child {
                border-left: 1px solid black;
            }
            #phantrang {
                width: 100%;
                height: 50px;
                border: 2px solid black;
                margin-top: 20px;
                margin-bottom: 20px;
            }
            .action-btn {
                cursor: pointer;
            }
            .pagination {
                display: inline-block;
                padding-left: 0;
                margin: 20px 0;
                border-radius: 4px;
            }
            .pagination > li {
                display: inline;
            }
            .pagination > li > a,
            .pagination > li > span {
                position: relative;
                float: left;
                padding: 6px 12px;
                margin-left: -1px;
                line-height: 1.42857143;
                color: #337ab7;
                text-decoration: none;
                background-color: #fff;
                border: 1px solid #ddd;
            }
            .pagination > li:first-child > a,
            .pagination > li:first-child > span {
                margin-left: 0;
                border-top-left-radius: 4px;
                border-bottom-left-radius: 4px;
            }
            .pagination > li:last-child > a,
            .pagination > li:last-child > span {
                border-top-right-radius: 4px;
                border-bottom-right-radius: 4px;
            }
            .pagination > li > a:hover,
            .pagination > li > span:hover,
            .pagination > li > a:focus,
            .pagination > li > span:focus {
                z-index: 2;
                color: #23527c;
                background-color: #eee;
                border-color: #ddd;
            }
            .pagination > .active > a,
            .pagination > .active > span,
            .pagination > .active > a:hover,
            .pagination > .active > span:hover,
            .pagination > .active > a:focus,
            .pagination > .active > span:focus {
                z-index: 3;
                color: #fff;
                cursor: default;
                background-color: #337ab7;
                border-color: #337ab7;
            }
            .pagination > .disabled > span,
            .pagination > .disabled > span:hover,
            .pagination > .disabled > span:focus,
            .pagination > .disabled > a,
            .pagination > .disabled > a:hover,
            .pagination > .disabled > a:focus {
                color: #777;
                cursor: not-allowed;
                background-color: #fff;
                border-color: #ddd;
            }
            .pagination-lg > li > a,
            .pagination-lg > li > span {
                padding: 10px 16px;
                font-size: 18px;
                line-height: 1.3333333;
            }
            .pagination-lg > li:first-child > a,
            .pagination-lg > li:first-child > span {
                border-top-left-radius: 6px;
                border-bottom-left-radius: 6px;
            }
            .pagination-lg > li:last-child > a,
            .pagination-lg > li:last-child > span {
                border-top-right-radius: 6px;
                border-bottom-right-radius: 6px;
            }
            .pagination-sm > li > a,
            .pagination-sm > li > span {
                padding: 5px 10px;
                font-size: 12px;
                line-height: 1.5;
            }
            .pagination-sm > li:first-child > a,
            .pagination-sm > li:first-child > span {
                border-top-left-radius: 3px;
                border-bottom-left-radius: 3px;
            }
            .pagination-sm > li:last-child > a,
            .pagination-sm > li:last-child > span {
                border-top-right-radius: 3px;
                border-bottom-right-radius: 3px;
            }
        </style>
    </head>

    <body>
        <!-- nav -->
        <%@ include file="/WEB-INF/views/client/common/header.jsp" %>
        <!--end nav-->
        <div class="container shopping-content">
            <form action="shopping" class="row search-area" method="get">
                <button
                    type="submit"
                    id="search-btn"

                    value="search"
                    class="col-lg-1"
                    style="padding: 0"
                    >
                    <span id="search-icon" href="#"><i class="fas fa-search"></i></span>
                    <label for="search-btn" style="cursor: pointer">Search</label>
                </button>
                <div id="selection-search" class="col-lg-2" style="padding: 0px">
                    <select name="category" id="category" >
                        <c:if test="${not empty category}">
                            <option value="${category}">${category}</option>
                        </c:if>

                        <option value="">all</option>


                        <c:forEach items="${listCategory}" var="item">
                            <option value="${item.getCateName()}">${item.getCateName()}</option>
                        </c:forEach>

                    </select>
                </div>
                <div class="col-lg-8" style="padding: 0">
                    <input id="search-input" name="key" type="text" value="${key}" />
                </div>
                <input type="hidden" value="" name="currentPage" id="currentPage" />
                <input type="hidden" id="action" value="search" name="action"/>
            </form>
            <div class="cart-container container-fluid">
                <div class="row">
                    <c:forEach items="${plantList.plants}" var="item">
                        <div class="col-lg-3 product-cart">
                            <div class="product-img">
                                <a href="product-detail?id=${item.PID}"
                                   ><img
                                        class="img-fluid"
                                        style="height: 300px;width: 100%;"
                                        src="resources/images/${item.imgPath}"
                                        alt=""
                                        /></a>
                            </div>
                            <form action="cart" method="post">
                                <div class="product-action-btn container-fluid">

                                    <div class="row action-btn">
<!--                                        <input class="col-lg-6" name="action" type="button" onclick="callCheckOutAPI(${item.PID})" style="text-align: center;background-color: red;color: white;font-size: larger;height: 50px;" value="BUY NOW"></input>-->
                                        <input class="col-lg-12" name="action" type="submit" style="text-align: center;background-color: red;color: white;font-size: larger;height: 50px;" value="ADD TO CART"></input>
                                        <input type="hidden" value="${item.PID}" name="id" />
                                    </div>

                                </div>
                            </form>
                            <div
                                class="product-description"
                                style="
                                display: flex;
                                justify-content: center;
                                flex-direction: column;
                                align-items: center;
                                margin-top: 10px;
                                "
                                >
                                <h4 style="overflow: hidden; text-align: center">
                                    ${item.PName}
                                </h4>
                                <span>${item.price}</span>
                            </div>
                        </div>
                    </c:forEach>


                </div>
            </div>
            <!--phan trang-->
            <div id="pagination" class="pagination">
                <ul class="pagination" id="pagination1"></ul>
            </div>
        </div>

        <!--footer-->
        <%@ include file="/WEB-INF/views/client/common/footer.jsp" %>
        <!--end footer-->
        
        <form method="get" action="checkout" id="form-checkout">
            <input name="action" value="BUY NOW">
            <input name="PID" id="form-checkout-pid" value="">
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
        <script src="js/script.js"></script>
        <script src="js/shopping.js"></script>

        <script type="text/javascript" src="resources/client/js/jquery.twbsPagination.js"></script>
        <script src="resources/client/js/script.js"></script>
        <script type="text/javascript">
            $(window).scroll(function () {
                var search_area = document.querySelector(".search-area");
                if ($(window).scrollTop() > 80) {
                    search_area.classList.add("sticky");
                } else {
                    search_area.classList.remove("sticky");
                }
            });

            let currentPage = ${plantList.currentPage}
            let pageControl;
            let pagObj;
            $(function () {
                pagObj = $("#pagination1").twbsPagination({
                    totalPages: ${plantList.getTotalItem()},
                    visiblePages: 5,
                    startPage: currentPage,
                    onPageClick: function (event, page) {
                        $("#currentPage").val(page);
                        $(".search-area").submit();
                    },
                });
            });
            function submitting() {}
            
            function callCheckOutAPI(PID) {
                $("#form-checkout-pid").val(PID);
                $("#form-checkout").submit();
            }
        </script>
    </body>
</html>

