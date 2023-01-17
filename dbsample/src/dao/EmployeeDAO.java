package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dept;
import model.Employee;
import model.Gender;

public class EmployeeDAO {
	private final String SQL_FIND_ALL =
			"SELECT" +
			"  e.id AS eid," +
			"  e.name AS ename, " +
			"  g.id AS gid, " +
			"  g.name AS gname, " +
			"  e.birthday AS birthday, " +
			"  d.id AS did, " +
			"  d.name AS dname " +
			"FROM employee e " +
			"INNER JOIN gender g " +
			"  ON e.gender_id = g.id " +
			"INNER JOIN dept d " +
			"  ON e.dept_id = d.id " +
			"ORDER BY e.id ASC";
	
	private final String SQL_FIND_EMP_BY_ID =
			"SELECT" +
			"  e.id AS eid," +
			"  e.name AS ename, " +
			"  g.id AS gid, " +
			"  g.name AS gname, " +
			"  e.birthday AS birthday, " +
			"  d.id AS did, " +
			"  d.name AS dname " +
			"FROM employee e " +
			"INNER JOIN gender g " +
			"  ON e.gender_id = g.id " +
			"INNER JOIN dept d " +
			"  ON e.dept_id = d.id " +
			" WHERE e.id = ?";

	private final String SQL_CREATE =
			"INSERT INTO employee" +
	        "  (id, name, gender_id, birthday, dept_id) " +
	        " VALUES (?, ?, ?, ?, ?)";
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt =
					conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				Employee emp = getEmp(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}  // findAll() end
	
	public Employee findEmpById(String id) {
		Employee emp = null;
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt =
					conn.prepareStatement(SQL_FIND_EMP_BY_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				emp = getEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return emp;
	}  // findEmpById() end

	public boolean create(Employee emp) {
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt =
					conn.prepareStatement(SQL_CREATE);
			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setString(3, emp.getGender().getId());
			pStmt.setString(4, emp.getBirthday());
			pStmt.setString(5, emp.getDept().getId());
			int result = pStmt.executeUpdate();
			
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private Employee getEmp(ResultSet rs) throws SQLException {
		String eid = rs.getString("eid");
		String ename = rs.getString("ename");
		String gid = rs.getString("gid");
		String gname = rs.getString("gname");
		Gender gender = new Gender(gid, gname);
		String birthday = rs.getString("birthday");
		String did = rs.getString("did");
		String dname = rs.getString("dname");
		Dept dept = new Dept(did, dname);
		Employee emp = 
				new Employee(eid, ename, gender, birthday, dept);
		return emp;
	}
	
}  // class end
