/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service;

import com.plantshop.entity.OrderDetail;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public interface OrderDetailService {


    public ArrayList<OrderDetail> findAllByOrderID(Integer OrderID);

    public Integer createOrderDetailByOrdID(Integer ordID, Integer PID, Integer amount);

}
