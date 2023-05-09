/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.client;

import com.plantshop.dto.PagingPlantDTO;
import com.plantshop.entity.Category;
import com.plantshop.entity.Plant;
import com.plantshop.service.CategoryService;
import com.plantshop.service.PlantService;
import com.plantshop.service_impl.CategoryServiceImpl;
import com.plantshop.service_impl.PlantServiceImp;
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
@WebServlet(name = "ClientShoppingController", urlPatterns = {"/shopping"})
public class ClientShoppingController extends HttpServlet {

    private PlantService plantService = new PlantServiceImp();

    private CategoryService categoryService = new CategoryServiceImpl();
    
    private void loadCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> categories = categoryService.findAll();
        req.setAttribute("listCategory", categories);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        loadCategory(req, resp);
        
        String action = req.getParameter("action");
        String currentPage = req.getParameter("currentPage");
        Integer offset = 0;
        if (currentPage == null || currentPage == "") {
            currentPage = "1";
        }
        if (currentPage != null) {
            if (!currentPage.matches("^[^a-zA-Z]*$")) {
                currentPage = "1";
            }
        }
        Integer limit = 16;
        offset = (Integer.parseInt(currentPage) - 1) * limit;

        if (action != null) {
            if (action.equals("search")) {
                String key = req.getParameter("key");
                String category = req.getParameter("category");
                if (key == null) {
                    key = "";
                }
                if (category == null) {
                    category = "";
                }
                ArrayList<Plant> plantList = plantService.findByNameAndCategoryWithOffsetAndLimitWithOrderBy(key, category, offset, limit, "PID");
                req.setAttribute("key", key);
                req.setAttribute("category", category);
                req.setAttribute("plantList", new PagingPlantDTO(plantList, Integer.parseInt(currentPage), (plantService.findByNameAndCategory(key, category).size() / limit) + 1));
                req.getRequestDispatcher("WEB-INF/views/client/shopping.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("error?statusCode=400");
            }
        } else {
            ArrayList<Plant> plantList = plantService.findByNameAndCategoryWithOffsetAndLimitWithOrderBy("", "", offset, limit, "PID");
            req.setAttribute("plantList", new PagingPlantDTO(plantList, Integer.parseInt(currentPage), (plantService.findByNameAndCategory("", "").size() / limit) + 1));
            req.getRequestDispatcher("WEB-INF/views/client/shopping.jsp").forward(req, resp);
        }
    }

}
