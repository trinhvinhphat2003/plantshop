/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.filter;

import com.plantshop.constant.AuthenticationConst;
import com.plantshop.entity.User;
import com.plantshop.service.CartService;
import com.plantshop.service.UserService;
import com.plantshop.service_impl.CartServiceImpl;
import com.plantshop.service_impl.UserServiceImp;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trình Vĩnh Phat
 */
@WebFilter(filterName = "AuthorFilter", urlPatterns = {"/*"})
public class AuthorFilter implements Filter {

    private ServletContext context;

    private CartService cartService;

    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
        cartService = new CartServiceImpl();
        userService = new UserServiceImp();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Integer role;

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        User user = (User) req.getSession().getAttribute("User");

        if (user == null) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                String email = "";
                String password = "";
                for (Cookie c : cookies) {
                    if (c.getName().equals("email")) {
                        email = c.getValue();
                    }
                    if (c.getName().equals("password")) {
                        password = c.getValue();
                    }
                }
                if (!email.isEmpty()) {
                    user = userService.findByEmailAndPassword(email, password);
                }
                if (user != null) {
                    req.getSession().setAttribute("User", user);
                }
            }
        }

        String url = req.getRequestURI();

        if (user != null & !url.contains("/admin")) {
            Integer count = cartService.countCartItem(user.getAccID());
            req.setAttribute("cartCountItem", count);
        }

        if (url.contains("/admin")) {
            if (user != null) {
                if (user.getRole() == AuthenticationConst.ADMIN) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect(req.getContextPath() + "/error?statusCode=" + HttpServletResponse.SC_FORBIDDEN);
                }
            } else {
                res.sendRedirect(req.getContextPath() + "/error?statusCode=" + HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

}
