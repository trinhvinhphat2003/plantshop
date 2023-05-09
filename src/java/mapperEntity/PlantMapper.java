package mapperEntity;

import com.plantshop.entity.Plant;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlantMapper implements RowMapper<Plant>{

	@Override
	public Plant mapRow(ResultSet rs) {
		try {
			return new Plant(rs.getInt("PID"), rs.getString("PName"), rs.getInt("price"), rs.getString("imgPath"), rs.getString("description"), rs.getInt("status"), rs.getInt("CatelD"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
