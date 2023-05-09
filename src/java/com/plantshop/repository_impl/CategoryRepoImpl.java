/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.repository_impl;

import com.plantshop.entity.Category;
import com.plantshop.repository.CategoryRepo;
import java.util.ArrayList;
import mapperEntity.CategoryMapper;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CategoryRepoImpl extends GenericRepoImpl<Category> implements CategoryRepo {

    @Override
    public ArrayList<Category> findAll() {
        StringBuilder query = new StringBuilder("select * from categories");
        return query(query.toString(), new CategoryMapper());
    }

    @Override
    public ArrayList<Category> findByID(Integer cateID) {
        StringBuilder query = new StringBuilder("select * from categories where cateld = ?");
        return query(query.toString(), new CategoryMapper(), cateID);
    }

    @Override
    public void updateCategoryByCateIDAndName(Integer id, String newCategory) {
        StringBuilder query = new StringBuilder("update categories set catename = ? where cateld = ?");
        update(query.toString(), newCategory, id);
    }

    @Override
    public Integer save(String category) {
        StringBuilder query = new StringBuilder("insert into categories(catename) values(?)");
        return insert(query.toString(), category);
    }

}
