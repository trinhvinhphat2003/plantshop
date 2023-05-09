/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.entity;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class OrderDetail {

    private Integer DetailId;
    private Integer OrderID;
    private Integer FID;
    private Integer quantity;

    public OrderDetail() {
    }

    public OrderDetail(Integer DetailId, Integer OrderID, Integer FID, Integer quantity) {
        this.DetailId = DetailId;
        this.OrderID = OrderID;
        this.FID = FID;
        this.quantity = quantity;
    }

    public Integer getDetailId() {
        return DetailId;
    }

    public void setDetailId(Integer DetailId) {
        this.DetailId = DetailId;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer OrderID) {
        this.OrderID = OrderID;
    }

    public Integer getFID() {
        return FID;
    }

    public void setFID(Integer FID) {
        this.FID = FID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
