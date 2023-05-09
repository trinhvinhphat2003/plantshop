/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.client;

import com.plantshop.constant.AuthenticationConst;
import com.plantshop.constant.StatusConst;
import com.plantshop.entity.User;
import com.plantshop.service.UserService;
import com.plantshop.service_impl.UserServiceImp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Trình Vĩnh Phat
 */
@WebServlet(name = "ClientLoginController", urlPatterns = {"/login"})
public class ClientLoginController extends HttpServlet {

    private UserService userService = new UserServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher("WEB-INF/views/client/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userService.findByEmailAndPassword(email, password);
        if (user.getStatus() == StatusConst.IS_BLOCKED) {
            req.setAttribute("errorMsg", "this accoint is blocked");
            req.getRequestDispatcher("WEB-INF/views/client/login.jsp").forward(req, resp);
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("User", user);
        if (user != null) {
            if (user.getRole() == AuthenticationConst.ADMIN) {
                String rememberme = req.getParameter("remember-me");
                if (rememberme != null) {
                    Cookie emailCookie = new Cookie("email", email);
                    emailCookie.setPath(req.getContextPath());
                    emailCookie.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(emailCookie);
                    Cookie passCookie = new Cookie("password", password);
                    passCookie.setPath(req.getContextPath());
                    passCookie.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(passCookie);
                    resp.sendRedirect(req.getContextPath() + "/admin-Home");
                    return;
                }
                resp.sendRedirect(req.getContextPath() + "/admin-Home");
            } else if (user.getRole() == AuthenticationConst.MEMBER) {
                String rememberme = req.getParameter("remember-me");
                if (rememberme != null) {
                    Cookie emailCookie = new Cookie("email", email);
                    emailCookie.setPath(req.getContextPath());
                    emailCookie.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(emailCookie);
                    Cookie passCookie = new Cookie("password", password);
                    passCookie.setPath(req.getContextPath());
                    passCookie.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(passCookie);
                    resp.sendRedirect(req.getContextPath() + "/home");
                    return;
                }
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            req.setAttribute("errorMsg", "email or password wrong");
            req.getRequestDispatcher("WEB-INF/views/client/login.jsp").forward(req, resp);
        }
    }

    

}
