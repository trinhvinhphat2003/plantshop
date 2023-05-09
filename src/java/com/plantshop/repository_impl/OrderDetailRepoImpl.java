/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.repository_impl;

import com.plantshop.entity.OrderDetail;
import com.plantshop.repository.OrderDetailRepo;
import java.util.ArrayList;
import mapperEntity.OrderDetailMapper;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class OrderDetailRepoImpl extends GenericRepoImpl<OrderDetail> implements OrderDetailRepo {

    @Override
    public ArrayList<OrderDetail> findAllByOrderID(Integer OrderID) {
        StringBuilder query = new StringBuilder("select * from orderdetails where orderid = ?");
        return query(query.toString(), new OrderDetailMapper(), OrderID);
    }

    @Override
    public Integer insertNewItemWithOrdID(Integer ordID, Integer PID, Integer amount) {
        StringBuilder query = new StringBuilder("insert into orderdetails(orderid, pid, quantity) values(?, ?, ?)");
        return insert(query.toString(), ordID, PID, amount);
    }

}
