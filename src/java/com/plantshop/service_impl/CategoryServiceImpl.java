/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service_impl;

import com.plantshop.entity.Category;
import com.plantshop.repository.CategoryRepo;
import com.plantshop.repository_impl.CategoryRepoImpl;
import com.plantshop.service.CategoryService;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo categoryRepo = new CategoryRepoImpl();

    @Override
    public ArrayList<Category> findAll() {
        ArrayList<Category> categories = categoryRepo.findAll();
        return categories.size() == 0 ? null : categories;
    }

    @Override
    public Category findByID(Integer cateID) {
        ArrayList<Category> categorys = categoryRepo.findByID(cateID);
        return categorys.size() == 0 ? null : categorys.get(0);
    }

    @Override
    public void updateCategoryByCateIDAndName(Integer id, String newCategory) {
        categoryRepo.updateCategoryByCateIDAndName(id, newCategory);
    }

    @Override
    public Integer save(String category) {
        return categoryRepo.save(category);
    }

}
