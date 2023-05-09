/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperEntity;

import com.plantshop.entity.Category;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trình Vĩnh Phat
 */
public class CategoryMapper implements RowMapper<Category> {
    
    @Override
    public Category mapRow(ResultSet rs) {
        try {
            return new Category(rs.getInt("CatelD"), rs.getString("CateName"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
