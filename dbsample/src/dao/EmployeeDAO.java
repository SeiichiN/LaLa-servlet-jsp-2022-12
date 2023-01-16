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

	private final String SQL_FIND_BY_ID =
			"SELECT "
			+ "  e.id AS eid,"
			+ "  e.name AS ename,"
			+ "  g.id AS gid,"
			+ "  g.name AS gname,"
			+ "  e.birthday AS birthday,"
			+ "  d.id AS did,"
			+ "  d.name AS dname "
			+ "FROM EMPLOYEE e "
			+ "INNER JOIN gender g "
			+ "  ON e.gender_id = g.id "
			+ "INNER JOIN dept d " 
			+ "  ON e.dept_id = d.id "
			+ "WHERE e.id = ? "
			+ "ORDER BY e.id ASC";

	private final String SQL_FIND_BY_NAME =
			"SELECT "
			+ "  e.id AS eid,"
			+ "  e.name AS ename,"
			+ "  g.id AS gid,"
			+ "  g.name AS gname,"
			+ "  e.birthday AS birthday,"
			+ "  d.id AS did,"
			+ "  d.name AS dname "
			+ " FROM EMPLOYEE e "
			+ " INNER JOIN gender g "
			+ "   ON e.gender_id = g.id "
			+ " INNER JOIN dept d " 
			+ "   ON e.dept_id = d.id "
			+ " WHERE e.name like ?"
			+ " ORDER BY e.id ASC";

	private final String SQL_FIND_BY_DEPT_ID =
			"SELECT "
			+ "  e.id AS eid,"
			+ "  e.name AS ename,"
			+ "  g.id AS gid,"
			+ "  g.name AS gname,"
			+ "  e.birthday AS birthday,"
			+ "  d.id AS did,"
			+ "  d.name AS dname "
			+ " FROM EMPLOYEE e "
			+ " INNER JOIN gender g "
			+ "   ON e.gender_id = g.id "
			+ " INNER JOIN dept d " 
			+ "   ON e.dept_id = d.id "
			+ " WHERE e.dept_id = ?"
			+ " ORDER BY e.id ASC";
	
	private final String SQL_FIND_NAME_BY_ID =
			"SELECT name FROM employee WHERE id = ?";
	
	private final String SQL_CREATE =
			"INSERT INTO employee " 
			+ " (id, name, gender_id, birthday, dept_id) "
			+ "VALUES (?, ?, ?, ?, ?)";
	
	private final String SQL_UPDATE = 
			"UPDATE employee " 
			+ " SET " 
			+ "  name = ?, " 
			+ "  gender_id = ?, "
			+ "  birthday = ?, " 
			+ "  dept_id = ? " 
			+ " WHERE id = ?";

	private final String SQL_DELETE =
			"DELETE FROM employee WHERE id = ?";
	
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
		Employee employee = null;
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				employee = getEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employee;
	} // findEmpById() end
	
	public List<Employee> findEmpByName(String name) {
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_NAME);
			pStmt.setString(1, "%" + name + "%");
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
	}  // findEmpByName() end
	
	public List<Employee> findEmpByDeptId(String deptId) {
		List<Employee> empList = new ArrayList<>();

		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_DEPT_ID);
			pStmt.setString(1, deptId);
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
	}
	
	public String findNameById(String id) {
		String name = null;
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_NAME_BY_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return name;
	}
	
	public boolean create(Employee emp) {
		try (Connection conn = DBConnect.connect()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt = conn.prepareStatement(SQL_CREATE);) {
				pStmt.setString(1, emp.getId());
				pStmt.setString(2, emp.getName());
				pStmt.setString(3, emp.getGender().getId());
				pStmt.setString(4, emp.getBirthday());
				pStmt.setString(5, emp.getDept().getId());
				int result = pStmt.executeUpdate();
				if (result != 1) {
					conn.rollback();
					return false;
				}
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteById(String id) {
		try (Connection conn = DBConnect.connect()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt = conn.prepareStatement(SQL_DELETE);) {
				pStmt.setString(1, id);
				int result = pStmt.executeUpdate();
				if (result != 1) {
					conn.rollback();
					return false;
				}
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Employee emp) {
		try (Connection conn = DBConnect.connect()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt = conn.prepareStatement(SQL_UPDATE);) {
				pStmt.setString(1, emp.getName());
				pStmt.setString(2, emp.getGender().getId());
				pStmt.setString(3, emp.getBirthday());
				pStmt.setString(4, emp.getDept().getId());
				pStmt.setString(5, emp.getId());
				int result = pStmt.executeUpdate();
				if (result != 1) {
					conn.rollback();
					return false;
				}
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				conn.rollback();
				throw e;
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
