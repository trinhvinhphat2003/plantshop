<%-- 
    Document   : home
    Created on : 28-02-2023, 10:14:39
    Author     : Trình Vĩnh Phat
--%>

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
    <link href="resources/client/css/style.css" rel="stylesheet" />
    <!--owl carousel-->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
      integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
      integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.green.min.css"
      integrity="sha512-C8Movfk6DU/H5PzarG0+Dv9MA9IZzvmQpO/3cIlGIflmtY3vIud07myMu4M/NTPJl8jmZtt/4mC9bAioMZBBdA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <style>
      .slider-content {
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
      }
      .slider {
        width: 90%;
        height: 50vh;
        border-radius: 5px;
        overflow: hidden;
        position: relative;
      }
      .slides {
        display: flex;
        width: 400%;
        height: 100%;
      }
      .slider input {
        display: none;
      }
      .slides img {
        width: 100%;
        height: 100%;
      }
      .slide {
        width: 25%;
        transition: 2s;
      }

      .navigation-manual {
        position: absolute;
        top: 360px;
        width: 100%;
        display: flex;
        justify-content: center;
      }
      .manual-btn {
        border: 2px solid black;
        padding: 5px;
        border-radius: 10px;
        cursor: pointer;
        transition: 1s;
      }
      .manual-btn:not(:last-child) {
        margin-right: 40px;
      }
      .manual-btn:hover {
        background: black;
      }
      #radio1:checked ~ .first {
        margin-left: 0;
      }
      #radio2:checked ~ .first {
        margin-left: -25%;
      }
      #radio3:checked ~ .first {
        margin-left: -50%;
      }
      #radio4:checked ~ .first {
        margin-left: -75%;
      }
      .navigation-auto {
        position: absolute;
        top: 360px;
        width: 100%;
        display: flex;
        justify-content: center;
      }
      .navigation-auto div {
        border: 2px solid black;
        padding: 5px;
        border-radius: 10px;
        cursor: pointer;
        transition: 1s;
      }
      .navigation-auto div:not(:last-child) {
        margin-right: 40px;
      }
      #radio1:checked ~ .navigation-auto .auto-btn1 {
        background: black;
      }
      #radio2:checked ~ .navigation-auto .auto-btn2 {
        background: black;
      }
      #radio3:checked ~ .navigation-auto .auto-btn3 {
        background: black;
      }
      #radio4:checked ~ .navigation-auto .auto-btn4 {
        background: black;
      }
      .shopping-btn {
        color: black;
        background-color: white;
        width: fit-content;
        height: fit-content;
        padding: 10px;
        border-radius: 10px;
        margin: auto;
        margin-top: 240px;
        cursor: pointer;
        transition: 0.5s;
      }
      .shopping-btn:hover {
        background-color: aqua;
      }
      
    </style>
  </head>

  <body>
    <!-- nav -->
    <%@ include file="/WEB-INF/views/client/common/header.jsp" %>
    <!--end nav-->
    <div id="home_content">
      <div class="container-fluid" style="width: 100%; height: 100%">
        <div class="row" style="height: 100%">
          <div class="col-lg-6" style="height: 100%">
            <div class="left-content" style="height: 100%">
              <a>
                <div class="shopping-btn">
                    <h1 style="overflow: hidden; margin: 0px"><a href="shopping" style="text-decoration: none;color: black">SHOP NOW</a></h1>
                </div>
              </a>
            </div>
          </div>
          <!--slide-->
          <div class="col-lg-6 slider-content">
            <h1
              class="text-uppercase"
              style="color: white; overflow-y: hidden; margin: 20px 0px"
            >
              NEW PLANTS
            </h1>
            <!--slider-->
            <div class="slider">
              <div class="slides">
                <!--radio-->
                <input type="radio" name="radio-btn" id="radio1" />
                <input type="radio" name="radio-btn" id="radio2" />
                <input type="radio" name="radio-btn" id="radio3" />
                <input type="radio" name="radio-btn" id="radio4" />
                <!---->
                <!--slide start-->
                <div class="slide first">
                  <a href="#"><img src="resources/images/${plantList.get(0).imgPath}" alt="" /></a>
                </div>
                <div class="slide">
                  <a href="#"><img src="resources/images/${plantList.get(1).imgPath}" alt="" /></a>
                </div>
                <div class="slide">
                  <a href="#"><img src="resources/images/${plantList.get(2).imgPath}" alt="" /></a>
                </div>
                <div class="slide">
                  <a href="#"><img src="resources/images/${plantList.get(3).imgPath}" alt="" /></a>
                </div>
                <!--slide end-->
                <!--slide nav auto-->
                <div class="navigation-auto">
                  <div class="auto-btn1"></div>
                  <div class="auto-btn2"></div>
                  <div class="auto-btn3"></div>
                  <div class="auto-btn4"></div>
                </div>
                <!---->
              </div>
              <!--slide nav manual-->
              <div class="navigation-manual">
                <label for="radio1" class="manual-btn"></label>
                <label for="radio2" class="manual-btn"></label>
                <label for="radio3" class="manual-btn"></label>
                <label for="radio4" class="manual-btn"></label>
              </div>

              <!---->
            </div>
            <!--end slider-->
          </div>
        </div>
      </div>
    </div>
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

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!--Thêm các tệp CSS và JS khác của Bootstrap vào đây-->
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"
      integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
    <script src="resources/client/js/script.js"></script>
    <script>
      let count = 1;

      $(document).ready(() => {
        let interval = setInterval(() => {
          document.getElementById("radio" + count).checked = true;
          count++;
          if (count > 4) count = 1;
        }, 3000);
        $(".slides .slide img").hover(
          function () {
            clearInterval(interval);
          },
          function () {
            interval = setInterval(() => {
              document.getElementById("radio" + count).checked = true;
              count++;
              if (count > 4) count = 1;
            }, 3000);
          }
        );
      });
    </script>
  </body>
</html>

