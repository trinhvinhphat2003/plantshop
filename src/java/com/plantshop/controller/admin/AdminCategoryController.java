/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.admin;

import com.plantshop.service.CategoryService;
import com.plantshop.service_impl.CategoryServiceImpl;
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
@WebServlet(name = "AdminCategoryController", urlPatterns = {"/admin-CategoryManaging"})
public class AdminCategoryController extends HttpServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listItem", categoryService.findAll());
        req.getRequestDispatcher("WEB-INF/views/admin/CategoryManaging.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                String newCategory = req.getParameter("newCategory");
                String id = req.getParameter("id");
                categoryService.updateCategoryByCateIDAndName(Integer.parseInt(id), newCategory);
                resp.sendRedirect("admin-CategoryManaging");
                return;
            case "add":
                String category = req.getParameter("category");
                categoryService.save(category);
                resp.sendRedirect("admin-CategoryManaging");
                return;
        }
    }


}
