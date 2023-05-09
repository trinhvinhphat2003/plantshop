/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.admin;

import com.plantshop.entity.Order;
import com.plantshop.entity.User;
import com.plantshop.service.OrderService;
import com.plantshop.service_impl.OrderServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trình Vĩnh Phat
 */
@WebServlet(name = "AdminOrderController", urlPatterns = {"/admin-OrderManaging"})
public class AdminOrderController extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("User");
        if (user != null) {
            String from = req.getParameter("from");
            String to = req.getParameter("to");

            if (from == null) {
                from = "";
            }
            if (to == null) {
                to = "";
            }

            ArrayList<Order> orders = orderService.findAllWithFilter(from, to);

            req.setAttribute("listItem", orders);
            req.getRequestDispatcher("WEB-INF/views/admin/OrderManaging.jsp").forward(req, resp);
        }

    }

}
