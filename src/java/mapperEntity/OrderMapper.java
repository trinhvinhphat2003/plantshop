/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperEntity;

import com.plantshop.entity.Order;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class OrderMapper implements RowMapper<Order> {
    
    @Override
    public Order mapRow(ResultSet rs) {
        try {
            return new Order(rs.getInt("OrderID"), new Date(rs.getDate("OrdDate").getTime() + (1000 * 60 * 60 * 24 * 2)), new Date(rs.getDate("shipdate").getTime() + (1000 * 60 * 60 * 24 * 2)), rs.getInt("status"), rs.getInt("AccID"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
