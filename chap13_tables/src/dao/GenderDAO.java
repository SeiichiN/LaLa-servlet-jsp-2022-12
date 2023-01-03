package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Birthday;
import model.Dept;
import model.Employee;
import model.Gender;

public class GenderDAO {
	private final String SQL_FIND_ALL =
			"SELECT id, name FROM gender ORDER BY id ASC";
	private final String SQL_FIND_BY_ID =
			"SELECT id, name FROM gender "
			+ "WHERE id = ?"
			+ "ORDER BY id ASC";

	public List<Gender> findAll() {
		List<Gender> genderList= new ArrayList<>();
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				Gender gender = getGender(rs);
				genderList.add(gender);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return genderList;
	}
	
	public Gender findById(String id) {
		Gender gender = null;
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				gender = getGender(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return gender;
		
	}

	private Gender getGender(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		Gender gender = new Gender(id, name);
		return gender;
	}

}
