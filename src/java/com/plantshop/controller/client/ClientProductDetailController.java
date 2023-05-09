/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.client;

import com.plantshop.entity.Plant;
import com.plantshop.service.PlantService;
import com.plantshop.service_impl.PlantServiceImp;
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
@WebServlet(name = "ClientProductDetailController", urlPatterns = {"/product-detail"})
public class ClientProductDetailController extends HttpServlet {

    PlantService plantService = new PlantServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("id");
        if (id != null) {
            if (id.matches("^[^a-zA-Z]*$")) {
                Plant plant = plantService.findById(Integer.parseInt(id));
                if (plant != null) {
                    req.setAttribute("Plant", plant);
                    req.getRequestDispatcher("WEB-INF/views/client/PlantDetail.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("error?statusCode=404");
                }
            } else {
                resp.sendRedirect("error?statusCode=400");
            }
        } else {
            resp.sendRedirect("error?statusCode=400");
        }
    }

}
