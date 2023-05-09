/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service;

import com.plantshop.entity.CartDetail;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public interface CartDetailService {

    public ArrayList<CartDetail> findByCartID(Integer cartID);

    public Integer addToCart(Integer cartID, Integer PID);

    public void deleteItem(Integer id);

    public void updateItem(Integer id, Integer amount);

    public void deleteByID(Integer detailID);

}
