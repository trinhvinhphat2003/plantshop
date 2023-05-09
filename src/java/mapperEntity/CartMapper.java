/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperEntity;

import com.plantshop.entity.Cart;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CartMapper implements RowMapper<Cart> {

    @Override
    public Cart mapRow(ResultSet rs) {
        try {
            return new Cart(rs.getInt("CartID"), rs.getInt("AccID"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
