/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.entity;

import java.sql.Date;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class Order {
    private Integer OrderID;
    private Date OrdDate;
    private Date shipdate;
    private Integer status;
    private Integer AccID;

    public Order() {
    }

    public Order(Integer OrderID, Date OrdDate, Date shipdate, Integer status, Integer AccID) {
        this.OrderID = OrderID;
        this.OrdDate = OrdDate;
        this.shipdate = shipdate;
        this.status = status;
        this.AccID = AccID;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer OrderID) {
        this.OrderID = OrderID;
    }

    public Date getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(Date OrdDate) {
        this.OrdDate = OrdDate;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAccID() {
        return AccID;
    }

    public void setAccID(Integer AccID) {
        this.AccID = AccID;
    }

}
