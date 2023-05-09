/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service_impl;

import com.plantshop.entity.Order;
import com.plantshop.repository.OrderRepo;
import com.plantshop.repository_impl.OrderRepoImpl;
import com.plantshop.service.OrderService;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo = new OrderRepoImpl();

    @Override
    public ArrayList<Order> findAllByAccID(Integer accID) {
        ArrayList<Order> orders = orderRepo.findAllByAccID(accID);
        return orders.size() == 0 ? null : orders;
    }

    @Override
    public Integer createOrderByAccID(Integer accID) {
        return orderRepo.createOrderWithCurrentTimeByAccID(accID);
    }

    @Override
    public Order findByOrdID(Integer OrdID) {
        ArrayList<Order> orders = orderRepo.findById(OrdID);
        return orders.size() == 0 ? null : orders.get(0);
    }

    @Override
    public void changeStatus(Integer orderID, Integer status) {
        if (status == 1) {
            orderRepo.changeStatusByID(orderID, 3);
        } else if (status == 3) {
            orderRepo.changeStatusByID(orderID, 1);
            Date orDate = new Date(System.currentTimeMillis());
            Date shipDate = new Date(orDate.getTime() + (1000 * 60 * 60 * 24 * 2));
            orderRepo.changOrderDateAndShipDate(orderID, orDate, shipDate);
        }

    }

    @Override
    public ArrayList<Order> findAllByAccIDWithFilter(Integer accID, String from, String to) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ordFrom = null;
        Date ordTo = null;
        if (from == "") {
            ordFrom = new Date(0);
        }
        if (to == "") {
            ordTo = new Date(System.currentTimeMillis());
        }
        try {
            if (from != "") {
                ordFrom = new Date(sdf.parse(from).getTime());
            }
            if (to != "") {
                ordTo = new Date(sdf.parse(to).getTime());
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }

        ArrayList<Order> orders = orderRepo.findAllByAccIDWithFilter(accID, ordFrom, ordTo);

        return orders.size() == 0 ? null : orders;
    }

    @Override
    public Object findAll() {
        ArrayList<Order> orders = orderRepo.findAll();
        return orders.size() == 0 ? null : orders;
    }

    @Override
    public ArrayList<Order> findAllWithFilter(String from, String to) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ordFrom = null;
        Date ordTo = null;
        if (from == "") {
            ordFrom = new Date(0);
        }
        if (to == "") {
            ordTo = new Date(System.currentTimeMillis());
        }
        try {
            if (from != "") {
                ordFrom = new Date(sdf.parse(from).getTime());
            }
            if (to != "") {
                ordTo = new Date(sdf.parse(to).getTime());
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }

        ArrayList<Order> orders = orderRepo.findAllWithFilter(ordFrom, ordTo);

        return orders.size() == 0 ? null : orders;
    }

}
