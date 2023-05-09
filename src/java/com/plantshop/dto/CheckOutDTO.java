/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.dto;

import com.plantshop.entity.CartDetail;
import com.plantshop.entity.Plant;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CheckOutDTO {
    private CartDetail cartItem;
    private Plant plant;

    public CheckOutDTO() {
    }

    public CheckOutDTO(CartDetail cartItem, Plant plant) {
        this.cartItem = cartItem;
        this.plant = plant;
    }

    public CartDetail getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartDetail cartItem) {
        this.cartItem = cartItem;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

}
