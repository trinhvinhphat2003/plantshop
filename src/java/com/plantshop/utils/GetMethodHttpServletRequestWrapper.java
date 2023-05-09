/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class GetMethodHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public GetMethodHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getMethod() {
        return "GET";
    }
}
