/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.dto;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class OrderDTO {
    private Integer OrderID;
    private String OrdDate;
    private String shipdate;
    private Integer status;
    private Integer AccID;

    public OrderDTO() {
    }

    public OrderDTO(Integer OrderID, String OrdDate, String shipdate, Integer status, Integer AccID) {
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

    public String getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(String OrdDate) {
        this.OrdDate = OrdDate;
    }

    public String getShipdate() {
        return shipdate;
    }

    public void setShipdate(String shipdate) {
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
