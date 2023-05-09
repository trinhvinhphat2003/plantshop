/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.client;

import com.plantshop.service.CartService;
import com.plantshop.service.UserService;
import com.plantshop.service_impl.CartServiceImpl;
import com.plantshop.service_impl.UserServiceImp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trình Vĩnh Phat
 */
@WebServlet(name = "ClientRegisterController", urlPatterns = {"/register"})
public class ClientRegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private UserService userService = new UserServiceImp();

    private CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/client/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re-password");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");

        if (email == null || password == null || re_password == null || fullname == null || phone == null) {
            request.setAttribute("errorMsg", "no imput can be null");
            request.getRequestDispatcher("WEB-INF/views/client/register.jsp").forward(request, response);
            return;
        }

        if (userService.findByEmail(email) != null) {
            request.setAttribute("errorMsg", "email is existed");
            request.getRequestDispatcher("WEB-INF/views/client/register.jsp").forward(request, response);
            return;
        }

        if (!phone.matches("[0-9]{10}")) {
            request.setAttribute("errorMsg", "phone must have 10 numbers");
            request.getRequestDispatcher("WEB-INF/views/client/register.jsp").forward(request, response);
            return;
        }

        if (!password.equals(re_password)) {
            request.setAttribute("errorMsg", "re-password is not the same with password");
            request.getRequestDispatcher("WEB-INF/views/client/register.jsp").forward(request, response);
            return;
        }
        Integer AccID = userService.signup(email, password, fullname);
        if (AccID == null) {
            request.getRequestDispatcher("error?statusCode=" + HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/home");
    }

}
