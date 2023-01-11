package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Gender;

public class GenderDAO {
	private final String SQL_FIND_BY_ID = 
			"SELECT id, name FROM gender "
			+ " WHERE id = ?";
			
	public Gender findById(String g_id) {
		Gender gender = null;
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt =
					conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, g_id);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				gender = getGender(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return gender;
	}  // findById() end
	
	private Gender getGender(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		Gender gender = new Gender(id, name);
		return gender;
	}
	
}  // class end
