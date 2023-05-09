/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.dto;

import com.plantshop.entity.Plant;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CartItemsDTO {
    private Integer quantity;
    private Plant plant;
    private Integer DetailID;

    public CartItemsDTO() {
    }

    public CartItemsDTO(Integer quantity, Plant plant, Integer DetailID) {
        this.quantity = quantity;
        this.plant = plant;
        this.DetailID = DetailID;
    }

    public CartItemsDTO(Integer quantity, Plant plant) {
        this.quantity = quantity;
        this.plant = plant;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Integer getDetailID() {
        return DetailID;
    }

    public void setDetailID(Integer DetailID) {
        this.DetailID = DetailID;
    }


}
