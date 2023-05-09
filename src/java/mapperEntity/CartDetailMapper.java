/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperEntity;

import com.plantshop.entity.CartDetail;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CartDetailMapper implements RowMapper<CartDetail> {
    
    @Override
    public CartDetail mapRow(ResultSet rs) {
        try {
            return new CartDetail(rs.getInt("DetailID"), rs.getInt("CartID"), rs.getInt("PID"), rs.getInt("quantity"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
