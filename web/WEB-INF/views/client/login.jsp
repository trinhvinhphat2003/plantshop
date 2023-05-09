<%-- 
    Document   : login
    Created on : 26-02-2023, 11:23:15
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
    </head>

    <body>
        <!-- nav -->
        <%@ include file="/WEB-INF/views/client/common/header.jsp" %>
        <!--end nav-->
        <main class="container-fluid">
            <form action="login" method="post" class="form" id="login-form">
                
                <h1 class="text-uppercase">Login</h1>
                <c:if test="${not empty errorMsg}">
                    <div class="alert alert-warning" style="margin-bottom: 0;margin-top: 20px">
                        <strong>Warning!</strong> ${errorMsg}
                    </div>
                </c:if>
                <div class="form-control-common">
                    <input id="email" name="email" type="email" placeholder="email" />
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control-common">
                    <input id="password" type="password" placeholder="password" name="password" />
                    <small></small>
                    <span></span>
                </div>

                <div id="remember-me-container">
                    <input type="checkbox" name="remember-me" id="remember-me" />
                    <label for="remember-me">remember me</label>
                </div>

                <button class="text-uppercase" type="submit" id="login-button">
                    log in
                </button>

                <div class="sign-up-link">
                    not a member? <a href="register" id="sign-up-link">sign up</a>
                </div>
            </form>
        </main>
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
            let login_form = document.getElementById("login-form");

            login_form.addEventListener("submit", (event) => {
                event.preventDefault();
                let email = login_form.querySelector("#email");
                let password = login_form.querySelector("#password");
                if (!checkEmptyError([email, password])) {
                    login_form.submit();
                }
            });


            function checkEmptyError(listInput) {
                let check = false;
                listInput = Array.from(listInput);
                listInput.forEach((element) => {
                    if (element.value.trim() == "") {
                        showError(element, "empty is not allowed");
                        check = true;
                    } else {
                        showSuccess(element);
                    }
                });
                return check;
            }

            function showError(input, message) {
                let parent = input.parentElement;
                parent.classList.remove("success");
                parent.classList.add("error");
                parent.querySelector("small").innerText = message;
            }

            function showSuccess(input) {
                let parent = input.parentElement;
                parent.classList.remove("error");
                parent.querySelector("small").innerText = "";
                parent.classList.add("success");
            }

            let log_in_link = document.getElementById("log-in-link");
            let sign_up_link = document.getElementById("sign-up-link");

            log_in_link.addEventListener("click", (event) => {
                register_form.style.display = "none";
                login_form.style.display = "block";
            });

            sign_up_link.addEventListener("click", (event) => {
                login_form.style.display = "none";
                register_form.style.display = "block";
            });
        </script>
    </body>
</html>
