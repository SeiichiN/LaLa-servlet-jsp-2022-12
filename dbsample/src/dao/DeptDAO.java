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
			"SELECT id, name FROM DEPT "
			+ " ORDER BY id ASC";
			
	public List<Dept> findAll() {
		List<Dept> deptList = new ArrayList<>();
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt =
					conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				Dept dept = getDept(rs);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return deptList;
	}  // findAll() end
	
	private Dept getDept(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		Dept dept = new Dept(id, name);
		return dept;
	}
	
}  // class end
