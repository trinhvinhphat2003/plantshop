/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.dto;

import com.plantshop.entity.Plant;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class PagingPlantDTO {
    private ArrayList<Plant> plants;
    private Integer currentPage;
    private Integer totalItem;

    public PagingPlantDTO() {
    }

    public PagingPlantDTO(ArrayList<Plant> plants, Integer currentPage, Integer totalItem) {
        this.plants = plants;
        this.currentPage = currentPage;
        this.totalItem = totalItem;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

}
