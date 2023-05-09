/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.repository;

import com.plantshop.entity.Order;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public interface OrderRepo {

    public ArrayList<Order> findOrderByAccIDAndStatus(Integer accID, int i);

    public Integer createOrderWithCurrentTimeByAccID(Integer accID);

    public ArrayList<Order> findAllByAccID(Integer accID);

    public Integer insertNewOrderByAccID(Integer accID);

    public ArrayList<Order> findById(Integer OrdID);

    public void changeStatusByID(Integer orderID, Integer status);

    public void changOrderDateAndShipDate(Integer orderID, Date orDate, Date shipDate);

    public ArrayList<Order> findAllByAccIDWithFilter(Integer accID, Date ordFrom, Date ordTo);

    public ArrayList<Order> findAll();

    public ArrayList<Order> findAllWithFilter(Date ordFrom, Date ordTo);

}
