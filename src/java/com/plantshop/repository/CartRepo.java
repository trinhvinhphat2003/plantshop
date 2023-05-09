/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.repository;

import com.plantshop.entity.Cart;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public interface CartRepo {

    public ArrayList<Cart> findCartByAccID(Integer accID);

    public Integer insertCartByAccID(Integer AccID);

}
