/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.client;

import com.plantshop.entity.User;
import com.plantshop.service.UserService;
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
@WebServlet(name = "ClientProfileController", urlPatterns = {"/profile"})
public class ClientProfileController extends HttpServlet {

    private UserService userService = new UserServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/client/profile.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("User");
        if (user != null) {
            String fullname = request.getParameter("fullname");
            String phone = request.getParameter("phone");
            if (fullname == null || phone == null) {
                response.sendRedirect("erroe?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            if (!phone.matches("[0-9]{10}")) {
                request.setAttribute("errorMsg", "Phone must have 10 numbers");
                request.getRequestDispatcher("WEB-INF/views/client/profile.jsp").forward(request, response);
                return;
            }
            userService.changeFullnameAndPhone(fullname, phone, user.getAccID());
            user.setFullname(fullname);
            user.setPhone(phone);
            request.getSession().setAttribute("User", user);
            request.getRequestDispatcher("WEB-INF/views/client/profile.jsp").forward(request, response);
            return;
        } else {
            request.setAttribute("errorMsg", "you have to log in to use this feature");
            request.getRequestDispatcher("login").forward(request, response);
        }
    }

}
