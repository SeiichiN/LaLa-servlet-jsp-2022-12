package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Employee;

public class EmployeeDAO {
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		DataSource ds = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/example_db");
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
		
		try (Connection conn = ds.getConnection();) {
			String sql = "select * from employee";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee emp = new Employee(id, name, age);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	private String sql = "INSERT INTO employee (id, name, age) VALUES (?, ?, ?)";
	private boolean isError = true;

	/**
	 * トランザクション処理を入れたメソッド
	 * @param emp
	 * @return
	 */
	public boolean create(Employee emp) {
		try (Connection conn = DBConnect.connect()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt1 = conn.prepareStatement(sql);) {
				pStmt1.setString(1, emp.getId());
				pStmt1.setString(2, emp.getName());
				pStmt1.setInt(3, emp.getAge());
				int result1 = pStmt1.executeUpdate();
				if (result1 != 1) {
					conn.rollback();
					return false;
				}
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * トランザクション処理
	 * ２つのSQL文の途中で例外が発生すると、1つ目のSQLの実行も取り消される。
	 * @param emp
	 * @return
	 */
	public boolean createYes(Employee emp) {
		try (Connection conn = DBConnect.connect()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt1 = conn.prepareStatement(sql);
				  PreparedStatement pStmt2 = conn.prepareStatement(sql)) {
				// 1つめの登録処理
				pStmt1.setString(1, emp.getId());
				pStmt1.setString(2, emp.getName());
				pStmt1.setInt(3, emp.getAge());
				int result1 = pStmt1.executeUpdate();
				if (result1 != 1) {
					conn.rollback();
					return false;
				}
				if (isError) { throw new SQLException("わざとエラー"); }
				// 2つめの登録処理
				pStmt2.setString(1, "EMP999");
				pStmt2.setString(2, "猿飛 佐助");
				pStmt2.setInt(3, 24);
				int result2 = pStmt2.executeUpdate();
				if (result2 != 1) {
					conn.rollback();
					return false;
				}
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * トランザクション処理なし
	 * １つめのSQL文の実行のあと例外が発生すると、１つめは実行されたあと。
	 * @param emp
	 * @return
	 */
	public boolean createNo(Employee emp) {
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt1 = conn.prepareStatement(sql);
			PreparedStatement pStmt2 = conn.prepareStatement(sql);	
			// 1つめの登録処理
			pStmt1.setString(1, emp.getId());
			pStmt1.setString(2, emp.getName());
			pStmt1.setInt(3, emp.getAge());
			int result1 = pStmt1.executeUpdate();
			if (result1 != 1) {
				return false;
			}
			if (isError) { throw new SQLException("わざとエラー"); }
			// 2つめの登録処理
			pStmt2.setString(1, "EMP010");
			pStmt2.setString(2, "猿飛 佐助");
			pStmt2.setInt(3, 24);
			int result2 = pStmt2.executeUpdate();
			if (result2 != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
