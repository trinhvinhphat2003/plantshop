/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.client;

import com.plantshop.dto.CheckOutDTO;
import com.plantshop.entity.Cart;
import com.plantshop.entity.CartDetail;
import com.plantshop.entity.User;
import com.plantshop.service.CartDetailService;
import com.plantshop.service.CartService;
import com.plantshop.service.OrderDetailService;
import com.plantshop.service.OrderService;
import com.plantshop.service.PlantService;
import com.plantshop.service_impl.CartDetailServiceImpl;
import com.plantshop.service_impl.CartServiceImpl;
import com.plantshop.service_impl.OrderDetailServiceImpl;
import com.plantshop.service_impl.OrderServiceImpl;
import com.plantshop.service_impl.PlantServiceImp;
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
@WebServlet(name = "ClientCheckoutController", urlPatterns = {"/checkout"})
public class ClientCheckoutController extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();

    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    private PlantService plantService = new PlantServiceImp();

    private CartService cartService = new CartServiceImpl();

    private CartDetailService cartDetailService = new CartDetailServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            String action = req.getParameter("action");
            if (action != null) {
                switch (action) {
//                    case "BUY NOW":
//                        String PID = req.getParameter("PID");
//                        if (PID != null) {
//                            if (PID.matches("[0-9]+")) {
//                                Plant plant = plantService.findById(Integer.parseInt(PID));
//
//                                if (plant == null) {
//                                    resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
//                                    return;
//                                }
//
//                                ArrayList<CheckOutDTO> chechOutItems = new ArrayList<>();
//                                chechOutItems.add(new CheckOutDTO(new CartDetail(null, null, plant.getPID(), 1), plant));
//                                req.setAttribute("listItem", chechOutItems);
//                                req.getRequestDispatcher("WEB-INF/views/client/checkout.jsp").forward(req, resp);
//                                return;
//                            } else {
//                                resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
//                                return;
//                            }
//                        } else {
//                            resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
//                            return;
//                        }

                    case "BUY FROM CART":
                        Cart cart = cartService.findCartByAccID(user.getAccID());
                        ArrayList<CartDetail> cartItems = cartDetailService.findByCartID(cart.getCartID());
                        ArrayList<CheckOutDTO> chechOutItems = new ArrayList<>();

                        if (cartItems != null) {

                            for (CartDetail cartItem : cartItems) {
                                chechOutItems.add(new CheckOutDTO(cartItem, plantService.findById(cartItem.getPID())));
                            }

                        } else {

                        }

                        req.setAttribute("listItem", chechOutItems);
                        req.getRequestDispatcher("WEB-INF/views/client/checkout.jsp").forward(req, resp);
                        return;

                    default:
                        resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
                        return;
                }
            } else {
                resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
            }

        } else {
            req.setAttribute("errorMsg", "You have to log in to use this feature");
            req.getRequestDispatcher("WEB-INF/views/client/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            String action = req.getParameter("action");
            if (action != null) {
                switch (action) {
//                    case "BUY NOW":
//                        String PID = req.getParameter("PID");
//                        if (PID != null) {
//                            if (PID.matches("[0-9]+")) {
//
//                                Plant plant = plantService.findById(Integer.parseInt(PID));
//                                if (plant != null) {
//                                    Integer ordID = orderService.createOrderByAccID(user.getAccID());
//                                    orderDetailService.createOrderDetailByOrdID(ordID, plant.getPID(), 1);
//                                } else {
//                                    resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
//                                    return;
//                                }
//
//                                ArrayList<CheckOutDTO> chechOutItems = new ArrayList<>();
//                                chechOutItems.add(new CheckOutDTO(new CartDetail(null, null, plant.getPID(), 1), plant));
//                                req.setAttribute("listItem", chechOutItems);
//                                req.getRequestDispatcher("WEB-INF/views/client/thank.jsp").forward(req, resp);
//                                return;
//                            } else {
//                                resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
//                                return;
//                            }
//                        } else {
//                            resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
//                            return;
//                        }

                    case "BUY FROM CART":


                        Cart cart = cartService.findCartByAccID(user.getAccID());
                        ArrayList<CartDetail> cartItems = cartDetailService.findByCartID(cart.getCartID());
                        ArrayList<CheckOutDTO> chechOutItems = new ArrayList<>();
                        Integer ordID = null;
                        if (cartItems != null) {
                            ordID = orderService.createOrderByAccID(user.getAccID());
                            for (CartDetail cartDetail : cartItems) {
                                orderDetailService.createOrderDetailByOrdID(ordID, cartDetail.getPID(), cartDetail.getQuantity());
                                chechOutItems.add(new CheckOutDTO(cartDetail, plantService.findById(cartDetail.getPID())));
                            }
                            for (CartDetail cartDetail : cartItems) {
                                cartDetailService.deleteByID(cartDetail.getDetailID());
                            }
                        } else {
                            resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
                            return;
                        }

                        req.setAttribute("listItem", chechOutItems);
                        //req.getRequestDispatcher("WEB-INF/views/client/thank.jsp").forward(req, resp);
                        req.getRequestDispatcher("thank?ordID=" + ordID).forward(req, resp);
                        return;

                    default:
                        resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
                        return;
                }
            } else {
                resp.sendRedirect("error?statusCode=" + HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            req.setAttribute("errorMsg", "You have to log in to use this feature");
            req.getRequestDispatcher("WEB-INF/views/client/login.jsp").forward(req, resp);
        }
    }

}
