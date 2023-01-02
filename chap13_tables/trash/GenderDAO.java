package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Gender;

public class GenderDAO {
	public List<Gender> findAll () {
		List<Gender> genderList = new ArrayList<>();
		try (Connection conn = DBConnect.connect()) {
			String sql = "SELECT id, name FROM gender";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Gender gender = new Gender(id, name);
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
			String sql = "SELECT name FROM gender WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				gender = new Gender(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return gender;
	}
}
