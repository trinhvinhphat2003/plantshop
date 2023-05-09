/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.dto;

import com.plantshop.entity.Category;
import com.plantshop.entity.Plant;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class AdminPlantDTO {
    private Plant plant;
    private Category category;

    public AdminPlantDTO() {
    }

    public AdminPlantDTO(Plant plant, Category category) {
        this.plant = plant;
        this.category = category;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
