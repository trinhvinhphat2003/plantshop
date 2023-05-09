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
public class Cart {
    private Integer CartID;
    private Integer AccID;

    public Cart() {
    }

    public Cart(Integer CartID, Integer AccID) {
        this.CartID = CartID;
        this.AccID = AccID;
    }

    public Integer getCartID() {
        return CartID;
    }

    public void setCartID(Integer CartID) {
        this.CartID = CartID;
    }

    public Integer getAccID() {
        return AccID;
    }

    public void setAccID(Integer AccID) {
        this.AccID = AccID;
    }

}
