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
public class CartDetail {
    private Integer DetailID;
    private Integer CartID;
    private Integer PID;
    private Integer Quantity;

    public CartDetail() {
    }

    public CartDetail(Integer DetailID, Integer CartID, Integer PID, Integer Quantity) {
        this.DetailID = DetailID;
        this.CartID = CartID;
        this.PID = PID;
        this.Quantity = Quantity;
    }

    public Integer getDetailID() {
        return DetailID;
    }

    public void setDetailID(Integer DetailID) {
        this.DetailID = DetailID;
    }

    public Integer getCartID() {
        return CartID;
    }

    public void setCartID(Integer CartID) {
        this.CartID = CartID;
    }

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

}
