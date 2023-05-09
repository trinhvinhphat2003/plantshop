/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.client;

import com.plantshop.dto.OrderItemDTO;
import com.plantshop.entity.Order;
import com.plantshop.entity.OrderDetail;
import com.plantshop.service.OrderDetailService;
import com.plantshop.service.OrderService;
import com.plantshop.service.PlantService;
import com.plantshop.service_impl.OrderDetailServiceImpl;
import com.plantshop.service_impl.OrderServiceImpl;
import com.plantshop.service_impl.PlantServiceImp;
import com.plantshop.utils.CaculatorUtil;
import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "ClientOrderDetailContrller", urlPatterns = {"/OrderDetail"})
public class ClientOrderDetailContrller extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();

    private PlantService plantService = new PlantServiceImp();

    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ordID = request.getParameter("id");
        if (ordID != null) {
            Order order = orderService.findByOrdID(Integer.parseInt(ordID));
            order.setOrdDate(new Date(order.getOrdDate().getTime() + (1000 * 60 * 60 * 24 * 2)));
            order.setShipdate(new Date(order.getShipdate().getTime() + (1000 * 60 * 60 * 24 * 2)));
            if (order != null) {
                ArrayList<OrderDetail> listItem = orderDetailService.findAllByOrderID(order.getOrderID());

                if (listItem != null) {
                    ArrayList<OrderItemDTO> listDTO = new ArrayList<>();
                    for (OrderDetail od : listItem) {
                        listDTO.add(new OrderItemDTO(od.getQuantity(), plantService.findById(od.getFID())));
                    }
                    request.setAttribute("listItem", listDTO);
                    request.setAttribute("total", CaculatorUtil.getTotalOfOrderItems(listDTO));
                    request.setAttribute("order", order);
                    request.getRequestDispatcher("WEB-INF/views/client/orderDetail.jsp").forward(request, response);
                    return;
                } else {
                    response.sendRedirect("error?statusCode=" + HttpServletResponse.SC_NOT_FOUND);
                    return;
                }
            } else {
                response.sendRedirect("error?statusCode=" + HttpServletResponse.SC_NOT_FOUND);
                return;
            }

        } else {
            response.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
        }
    }


}
