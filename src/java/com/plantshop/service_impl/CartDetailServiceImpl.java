/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.service_impl;

import com.plantshop.entity.CartDetail;
import com.plantshop.repository.CartDetailRepo;
import com.plantshop.repository_impl.CartdetailRepoImpl;
import com.plantshop.service.CartDetailService;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CartDetailServiceImpl implements CartDetailService {

    private CartDetailRepo cartDetailRepo = new CartdetailRepoImpl();

    @Override
    public ArrayList<CartDetail> findByCartID(Integer cartID) {
        ArrayList<CartDetail> cartDetails = cartDetailRepo.findByCartID(cartID);
        return cartDetails.size() == 0 ? null : cartDetails;
    }

    @Override
    public Integer addToCart(Integer cartID, Integer PID) {
        Integer results = null;
        ArrayList<CartDetail> cartDetails = cartDetailRepo.findByCartID(cartID);
        for (CartDetail item : cartDetails) {
            if (item.getPID() == PID) {
                cartDetailRepo.updateQuantity(item.getDetailID(), item.getQuantity() + 1);
                results = item.getPID();
                return results;
            }
        }
        results = cartDetailRepo.insertOne(cartID, PID);
        return results == null ? null : results;
    }

    @Override
    public void deleteItem(Integer id) {
        cartDetailRepo.deleteItem(id);
    }

    @Override
    public void updateItem(Integer id, Integer amount) {
        cartDetailRepo.updateQuantity(id, amount);
    }

    @Override
    public void deleteByID(Integer detailID) {
        cartDetailRepo.deleteItem(detailID);
    }
    
}
