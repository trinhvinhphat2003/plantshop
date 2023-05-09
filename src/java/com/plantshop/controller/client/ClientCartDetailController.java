/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.client;

import com.plantshop.dto.CartItemsDTO;
import com.plantshop.entity.Cart;
import com.plantshop.entity.CartDetail;
import com.plantshop.entity.User;
import com.plantshop.service.CartDetailService;
import com.plantshop.service.CartService;
import com.plantshop.service.PlantService;
import com.plantshop.service_impl.CartDetailServiceImpl;
import com.plantshop.service_impl.CartServiceImpl;
import com.plantshop.service_impl.PlantServiceImp;
import com.plantshop.utils.CaculatorUtil;
import java.io.IOException;
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
@WebServlet(name = "ClientCartController", urlPatterns = {"/cart"})
public class ClientCartDetailController extends HttpServlet {

    private CartService cartService = new CartServiceImpl();

    private CartDetailService cartDetailService = new CartDetailServiceImpl();

    private PlantService plantService = new PlantServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            Cart cart = cartService.findCartByAccID(user.getAccID());
            if (cart != null) {
                ArrayList<CartDetail> cartItems = cartDetailService.findByCartID(cart.getCartID());
                ArrayList<CartItemsDTO> listItem = new ArrayList<>();
                if (cartItems != null) {
                    for (CartDetail cartItem : cartItems) {
                        listItem.add(new CartItemsDTO(cartItem.getQuantity(), plantService.findById(cartItem.getPID()), cartItem.getDetailID()));
                    }
                    req.setAttribute("total", CaculatorUtil.getTotalOfCart(listItem));
                    req.setAttribute("listItem", listItem);
                }
            } else {
                resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return;
            }
            req.getRequestDispatcher("WEB-INF/views/client/cart.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMsg", "You have to log in to use this feature");
            req.getRequestDispatcher("WEB-INF/views/client/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String id = req.getParameter("id");
        if (action != null || id == null) {
            if (action.equals("ADD TO CART") && id.matches("[0-9]+") && id != "") {
                User user = (User) req.getSession().getAttribute("User");

                if (user != null) {
                    Cart cart = cartService.findCartByAccID(user.getAccID());
                    Integer CDID = cartDetailService.addToCart(cart.getCartID(), Integer.parseInt(id));
                    if (CDID != null) {
                        resp.sendRedirect("cart");
                        //req.getRequestDispatcher("WEB-INF/views/client/cart.jsp").forward(req, resp);
                    } else {
                        resp.sendRedirect("error?statusCode = " + HttpServletResponse.SC_BAD_REQUEST);
                    }
                } else {
//                    Cookie[] cookies = req.getCookies();
//                    for (Cookie c : cookies) {
//                        if (c.getName().equals(id)) {
//                            Integer newQuantity = Integer.parseInt(c.getValue()) + 1;
//                            c.setValue(String.valueOf(newQuantity));
//                            resp.addCookie(c);
//                            resp.sendRedirect("cart");
//                            return;
//                        }
//                    }
//                    Cookie cookie = new Cookie(id, "1");
//                    cookie.setPath(req.getContextPath());
//                    cookie.setMaxAge(60 * 60 * 24 * 7);
//                    resp.addCookie(cookie);
//                    resp.sendRedirect("cart");
//                    return;
                    req.setAttribute("errorMsg", "You have to log in to use this feature");
                    req.getRequestDispatcher("WEB-INF/views/client/login.jsp").forward(req, resp);
                }
            } else if (action.equals("DELETE") && id.matches("[0-9]+") && id != "") {
                cartDetailService.deleteItem(Integer.parseInt(id));
                resp.sendRedirect("cart");
                return;
            } else if (action.equals("UPDATE") && id.matches("[0-9]+") && id != "") {
                String amount = req.getParameter("amount");
                if (!amount.matches("[0-9]+")) {
                    resp.sendRedirect("error?statusCode = " + HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }
                if (Integer.parseInt(amount) <= 0) {
                    cartDetailService.deleteItem(Integer.parseInt(id));
                    resp.sendRedirect("cart");
                    return;
                }
                cartDetailService.updateItem(Integer.parseInt(id), Integer.parseInt(amount));
                resp.sendRedirect("cart");
                return;
            } else {
                resp.sendRedirect("error?statusCode = " + HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendRedirect("error?statusCode = " + HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
