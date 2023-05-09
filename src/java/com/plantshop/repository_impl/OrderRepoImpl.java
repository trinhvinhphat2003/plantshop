/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.repository_impl;

import com.plantshop.entity.Order;
import com.plantshop.repository.OrderRepo;
import java.sql.Date;
import java.util.ArrayList;
import mapperEntity.OrderMapper;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class OrderRepoImpl extends GenericRepoImpl<Order> implements OrderRepo {

    @Override
    public ArrayList<Order> findOrderByAccIDAndStatus(Integer accID, int i) {
        StringBuilder query = new StringBuilder("");
        return null;
    }

    @Override
    public Integer createOrderWithCurrentTimeByAccID(Integer accID) {
        StringBuilder query = new StringBuilder("insert into Orders(\n"
                + "	OrdDate, shipdate, status, AccID\n"
                + ")\n"
                + "values(\n"
                + "	?,\n"
                + "	?,\n"
                + "	1,\n"
                + "	?\n"
                + ")");
        Long currentTimeMili = System.currentTimeMillis();
        return insert(query.toString(), new Date(currentTimeMili), new Date(currentTimeMili + (60 * 1000 * 60 * 24 * 2)), accID);
    }

    @Override
    public ArrayList<Order> findAllByAccID(Integer accID) {
        StringBuilder query = new StringBuilder("select * from orders where accid = ?");
        return query(query.toString(), new OrderMapper(), accID);
    }

    @Override
    public Integer insertNewOrderByAccID(Integer accID) {
        StringBuilder query = new StringBuilder("insert into table orders(accid) values(?)");
        return insert(query.toString(), accID);
    }

    @Override
    public ArrayList<Order> findById(Integer OrdID) {
        StringBuilder query = new StringBuilder("select * from Orders where orderid = ?");
        return query(query.toString(), new OrderMapper(), OrdID);
    }

    @Override
    public void changeStatusByID(Integer orderID, Integer status) {
        StringBuilder query = new StringBuilder("update orders set [status] = ? where OrderID = ?");
        update(query.toString(), status, orderID);
    }

    @Override
    public void changOrderDateAndShipDate(Integer orderID, Date orDate, Date shipDate) {
        StringBuilder query = new StringBuilder("update orders set [OrdDate] = ?, [shipdate] = ? where OrderID = ?");
        update(query.toString(), orDate, shipDate, orderID);
    }

    @Override
    public ArrayList<Order> findAllByAccIDWithFilter(Integer accID, Date ordFrom, Date ordTo) {
        StringBuilder query = new StringBuilder("select * from orders where accid = ? and OrdDate between ? and ?");
        return query(query.toString(), new OrderMapper(), accID, ordFrom, ordTo);
    }

    @Override
    public ArrayList<Order> findAll() {
        StringBuilder query = new StringBuilder("select * from orders");
        return query(query.toString(), new OrderMapper());
    }

    @Override
    public ArrayList<Order> findAllWithFilter(Date ordFrom, Date ordTo) {
        StringBuilder query = new StringBuilder("select * from orders where OrdDate between ? and ?");
        return query(query.toString(), new OrderMapper(), ordFrom, ordTo);
    }

}
