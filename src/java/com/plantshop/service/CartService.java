/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service;

import com.plantshop.entity.Cart;

/**
 *
 * @author Trình Vĩnh Phat
 */
public interface CartService {

    public Cart findCartByAccID(Integer accID);

    public Integer countCartItem(Integer accID);

    public Integer createCartByAccID(Integer AccID);

}
