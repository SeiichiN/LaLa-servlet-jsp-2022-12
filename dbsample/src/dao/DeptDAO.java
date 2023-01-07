package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dept;

public class DeptDAO {
	private final String SQL_FIND_ALL = 
			"SELECT id, name FROM dept ORDER BY id ASC";
	private final String SQL_FIND_BY_ID = 
			"SELECT name FROM dept WHERE id = ?";
	
	public List<Dept> findAll() {
		List<Dept> deptList= new ArrayList<>();
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Dept dept = new Dept(id, name);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return deptList;
	}

	public Dept findById(String id) {
		Dept dept= null;
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				dept = new Dept(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return dept;
	}
}
