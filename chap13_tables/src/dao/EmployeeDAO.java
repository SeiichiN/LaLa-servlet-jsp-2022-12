package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Birthday;
import model.Dept;
import model.Employee;
import model.Gender;
import model.ParamEmp;

public class EmployeeDAO {
	private static int lastId;
	
	private final String SQL_FIND_ALL =
			"SELECT "
			+ "  e.id AS eid,"
			+ "  e.name AS ename,"
			+ "  g.id AS gid,"
			+ "  g.name AS gname,"
			+ "  e.birthday,"
			+ "  d.id AS did,"
			+ "  d.name AS dname "
			+ "FROM EMPLOYEE e "
			+ "INNER JOIN gender g "
			+ "  ON e.gender_id = g.id "
			+ "INNER JOIN department d "
			+ "  ON e.dept_id = d.id "
			+ "ORDER BY e.id ASC";

	private final String SQL_FIND_BY_ID =
			"SELECT "
			+ "  e.id AS eid,"
			+ "  e.name AS ename,"
			+ "  g.id AS gid,"
			+ "  g.name AS gname,"
			+ "  e.birthday,"
			+ "  d.id AS did,"
			+ "  d.name AS dname "
			+ "FROM EMPLOYEE e "
			+ "INNER JOIN gender g "
			+ "  ON e.gender_id = g.id "
			+ "INNER JOIN department d " 
			+ "  ON e.dept_id = d.id "
			+ "WHERE e.id = ? "
			+ "ORDER BY e.id ASC";
			
	private final String SQL_CREATE =
			"INSERT INTO employee " 
			+ " (name, gender_id, birthday, dept_id) "
			+ "VALUES (?, ?, ?, ?)";
	
	public static int getLastId() {
		return lastId;
	}
	
	public boolean create(ParamEmp emp) {
		Birthday birthday = new Birthday(emp.getBirthday());
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = 
					conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, emp.getName());
			pStmt.setString(2, emp.getGender_id());
			pStmt.setDate(3, birthday.getSqlDate());
			pStmt.setString(4, emp.getDept_id());
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
			// Statement.getGeneratedKeys()
			// https://stackoverflow.com/questions/9353167/auto-increment-id-in-h2-database
			// 
			// JDBCでINSERT後のシーケンス値を取得する
			// https://edgegram.hatenablog.jp/entry/2015/12/21/171306
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				EmployeeDAO.lastId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Employee> findAll() {
		List<Employee> empList= new ArrayList<>();
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				Employee employee = getEmp(rs);
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	public Employee findById(int id) {
		Employee employee = null;
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				employee = getEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employee;
		
	}
	
	private Employee getEmp(ResultSet rs) throws SQLException {
		int id = rs.getInt("eid");
		String name = rs.getString("ename");
		String gid = rs.getString("gid");
		String gname = rs.getString("gname");
		Gender gender = new Gender(gid, gname);
		String _birthday = rs.getString("birthday");
		Birthday birthday = new Birthday(_birthday);
		String did = rs.getString("did");
		String dname = rs.getString("dname");
		Dept dept = new Dept(did, dname);
		Employee employee = new Employee(id, name, gender, birthday, dept);
		return employee;
	}
}
