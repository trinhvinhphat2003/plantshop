/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.repository_impl;

import com.plantshop.entity.Cart;
import com.plantshop.repository.CartRepo;
import java.util.ArrayList;
import mapperEntity.CartMapper;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CartRepoImpl extends GenericRepoImpl<Cart> implements CartRepo {

    @Override
    public ArrayList<Cart> findCartByAccID(Integer accID) {
        StringBuilder query = new StringBuilder("select * from carts where AccID = ?");
        return query(query.toString(), new CartMapper(), accID);
    }

    @Override
    public Integer insertCartByAccID(Integer AccID) {
        StringBuilder query = new StringBuilder("insert into Carts(AccID) values(?)");
        return insert(query.toString(), AccID);
    }

}
