package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dept;

public class DeptDAO {

	public List<Dept> findAll() {
		List<Dept> deptList= new ArrayList<>();
		
		try (Connection conn = DBConnect.connect()) {
			String sql = "SELECT id, name FROM department";
			PreparedStatement pStmt = conn.prepareStatement(sql);
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
			String sql = "SELECT name FROM department WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
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
