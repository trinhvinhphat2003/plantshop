/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperEntity;

import com.plantshop.entity.OrderDetail;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class OrderDetailMapper implements RowMapper<OrderDetail> {
    
    @Override
    public OrderDetail mapRow(ResultSet rs) {
        try {
            return new OrderDetail(rs.getInt("DetailID"), rs.getInt("OrderID"), rs.getInt("PID"), rs.getInt("quantity"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
