/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service;

import com.plantshop.entity.Category;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public interface CategoryService {

    public ArrayList<Category> findAll();

    public Category findByID(Integer cateID);

    public void updateCategoryByCateIDAndName(Integer id, String newCategory);

    public Integer save(String category);

}
