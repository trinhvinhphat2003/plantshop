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
public class Category {
    private Integer CateID;
    private String CateName;

    public Category() {
    }

    public Category(Integer CateID, String CateName) {
        this.CateID = CateID;
        this.CateName = CateName;
    }

    public Integer getCateID() {
        return CateID;
    }

    public void setCateID(Integer CateID) {
        this.CateID = CateID;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }

}
