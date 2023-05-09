/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.repository_impl;

import com.plantshop.entity.CartDetail;
import com.plantshop.repository.CartDetailRepo;
import java.util.ArrayList;
import mapperEntity.CartDetailMapper;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CartdetailRepoImpl extends GenericRepoImpl<CartDetail> implements CartDetailRepo {

    @Override
    public ArrayList<CartDetail> findByCartID(Integer cartID) {
        StringBuilder query = new StringBuilder("select * from cartdetails where cartid = ?");
        return query(query.toString(), new CartDetailMapper(), cartID);
    }

    @Override
    public Integer insertOne(Integer cartID, Integer PID) {
        StringBuilder query = new StringBuilder("insert into cartdetails(cartID, PID, quantity) values(?, ?, 1)");
        return insert(query.toString(), cartID, PID);
    }

    @Override
    public void updateQuantity(Integer detailID, Integer quantity) {
        StringBuilder query = new StringBuilder("update cartdetails set quantity = ? where detailid = ?");
        update(query.toString(), quantity, detailID);
    }

    @Override
    public void deleteItem(Integer id) {
        StringBuilder query = new StringBuilder("delete cartdetails where detailid = ?");
        delete(query.toString(), id);
    }

    @Override
    public Integer countItem(Integer CartID) {
        StringBuilder query = new StringBuilder("select count(*) from cartdetails where cartid = ?");
        return count(query.toString(), CartID);
    }

}
