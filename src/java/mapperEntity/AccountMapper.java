package mapperEntity;

import com.plantshop.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs) {
		try {
			return new User(rs.getInt("accID"), rs.getString("email"), rs.getString("password"), rs.getString("fullname"), rs.getString("phone"), rs.getInt("status"), rs.getInt("role"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
