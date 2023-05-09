/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service;

import com.plantshop.entity.Order;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public interface OrderService {

    public ArrayList<Order> findAllByAccID(Integer accID);

    public ArrayList<Order> findAllByAccIDWithFilter(Integer accID, String from, String to);

    public Integer createOrderByAccID(Integer accID);

    public Order findByOrdID(Integer OrdID);

    public void changeStatus(Integer orderID, Integer status);

    public Object findAll();

    public ArrayList<Order> findAllWithFilter(String from, String to);

}
