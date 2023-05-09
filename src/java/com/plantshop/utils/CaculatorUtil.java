/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.utils;

import com.plantshop.dto.CartItemsDTO;
import com.plantshop.dto.OrderItemDTO;
import java.util.ArrayList;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CaculatorUtil {
    public static Integer getTotalOfCart(ArrayList<CartItemsDTO> items) {
        Integer total = 0;
        for (CartItemsDTO item : items) {
            total += item.getQuantity() * item.getPlant().getPrice();
        }
        return total;
    }

    public static Integer getTotalOfOrderItems(ArrayList<OrderItemDTO> listItem) {
        Integer total = 0;
        for (OrderItemDTO item : listItem) {
            total += item.getQuantity() * item.getPlant().getPrice();
        }
        return total;
    }
}
