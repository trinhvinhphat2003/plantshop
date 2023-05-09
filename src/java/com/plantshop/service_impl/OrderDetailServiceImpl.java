/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service_impl;

import com.plantshop.entity.OrderDetail;
import com.plantshop.repository.OrderDetailRepo;
import com.plantshop.repository_impl.OrderDetailRepoImpl;
import com.plantshop.service.OrderDetailService;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepo orderDetailRepo = new OrderDetailRepoImpl();

    @Override
    public ArrayList<OrderDetail> findAllByOrderID(Integer OrderID) {
        ArrayList<OrderDetail> orderDetails = orderDetailRepo.findAllByOrderID(OrderID);
        return orderDetails.size() == 0 ? null : orderDetails;
    }

    @Override
    public Integer createOrderDetailByOrdID(Integer ordID, Integer PID, Integer amount) {
        return orderDetailRepo.insertNewItemWithOrdID(ordID, PID, amount);
    }

}
