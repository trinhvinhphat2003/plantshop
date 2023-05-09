/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.client;

import com.plantshop.dto.OrderDTO;
import com.plantshop.entity.Order;
import com.plantshop.entity.User;
import com.plantshop.service.OrderDetailService;
import com.plantshop.service.OrderService;
import com.plantshop.service_impl.OrderDetailServiceImpl;
import com.plantshop.service_impl.OrderServiceImpl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Trình Vĩnh Phat
 */
@WebServlet(name = "ClientOrderController", urlPatterns = {"/order"})
public class ClientOrderController extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();

    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String from = req.getParameter("from");
        String to = req.getParameter("to");

        if (from == null) {
            from = "";
        }
        if (to == null)
            to = "";
        
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Order> orders = orderService.findAllByAccIDWithFilter(user.getAccID(), from, to);
            ArrayList<OrderDTO> listOrder = new ArrayList<>();
            if (orders == null) {
                orders = new ArrayList<Order>();
            }
            for (Order order : orders) {
                listOrder.add(new OrderDTO(order.getOrderID(), formatter.format(order.getOrdDate()), formatter.format(order.getShipdate()), order.getStatus(), order.getAccID()));
                //listOrder.add(new OrderDTO(order.getOrderID(), String.format("%1$td/%1$tm/%1$tY", order.getOrdDate()), String.format("%1$td/%1$tm/%1$tY", order.getShipdate().toLocalDate()), order.getStatus(), order.getAccID()));
                //listOrder.add(new OrderDTO(order.getOrderID(), new Date(order.getOrdDate().getTime() + (1000 * 60 * 60 * 24 * 2)).toString(), new Date(order.getShipdate().getTime() + (1000 * 60 * 60 * 24 * 2)).toString(), order.getStatus(), order.getAccID()));
            }
            if (orders != null) {
                req.setAttribute("listItem", listOrder);
            } else {
                req.setAttribute("emptyMsg", "empty");
            }
            req.getRequestDispatcher("WEB-INF/views/client/order.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMsg", "You have to log in to use this feature");
            req.getRequestDispatcher("WEB-INF/views/client/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "changeStatus":
                    String id = req.getParameter("id");
                    if (id != null) {
                        Order order = orderService.findByOrdID(Integer.parseInt(id));
                        if (order != null) {
                            orderService.changeStatus(order.getOrderID(), order.getStatus());
                            resp.sendRedirect("order");
                            return;
                        } else {
                            resp.sendRedirect("error?statusCode=404");
                            return;
                        }
                    } else {
                        resp.sendRedirect("error?statusCode=404");
                        return;
                    }
            }
        } else {
            resp.sendRedirect("error?statusCode=404");
        }
    }

}
