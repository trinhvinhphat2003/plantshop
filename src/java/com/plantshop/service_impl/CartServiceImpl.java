/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service_impl;

import com.plantshop.entity.Cart;
import com.plantshop.repository.CartDetailRepo;
import com.plantshop.repository.CartRepo;
import com.plantshop.repository_impl.CartRepoImpl;
import com.plantshop.repository_impl.CartdetailRepoImpl;
import com.plantshop.service.CartService;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CartServiceImpl implements CartService {

    private CartRepo cartRepo = new CartRepoImpl();

    private CartDetailRepo cartDetailRepoo = new CartdetailRepoImpl();


    @Override
    public Cart findCartByAccID(Integer accID) {
        ArrayList<Cart> carts = cartRepo.findCartByAccID(accID);        
        return carts.size() == 0 ? null : carts.get(0);
    }

    @Override
    public Integer countCartItem(Integer accID) {
        Integer CartID = findCartByAccID(accID).getCartID();
        if (CartID == null) {
            return 0;
        }
        Integer result = cartDetailRepoo.countItem(CartID);
        return result;

    }

    @Override
    public Integer createCartByAccID(Integer AccID) {
        return cartRepo.insertCartByAccID(AccID);
    }

}
