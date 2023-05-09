/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.admin;

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
@WebServlet(name = "AdminAccountController", urlPatterns = {"/admin-AccountManaging"})
public class AdminAccountController extends HttpServlet {

    private UserService userService = new UserServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listItem", userService.findAll());
        req.getRequestDispatcher("WEB-INF/views/admin/AccountManaging.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "block":
                String id = req.getParameter("id");
                userService.changeStatus(Integer.parseInt(id), 0);
                resp.sendRedirect("admin-AccountManaging");
                return;
            case "unblock":
                id = req.getParameter("id");
                userService.changeStatus(Integer.parseInt(id), 1);
                resp.sendRedirect("admin-AccountManaging");
                return;
        }
    }
    

}
