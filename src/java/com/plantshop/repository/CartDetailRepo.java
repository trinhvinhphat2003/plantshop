/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.repository;

import com.plantshop.entity.CartDetail;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public interface CartDetailRepo {

    public ArrayList<CartDetail> findByCartID(Integer cartID);

    public Integer insertOne(Integer cartID, Integer PID);

    public void updateQuantity(Integer detailID, Integer quantity);

    public void deleteItem(Integer id);

    public Integer countItem(Integer CartID);

}
