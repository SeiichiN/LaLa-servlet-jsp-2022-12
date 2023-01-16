package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
	private final String SQL_FIND_ALL =
			" SELECT" +
			"   du.id AS id," +
			"   e.name AS name," +
			"   du.pass AS pass" +
			" FROM dbuser du" +
			" INNER JOIN employee e" +
			"   ON du.id = e.id" +
			" ORDER BY du.id ASC";
	
	private final String SQL_FIND_USER_BY_ID =
			" SELECT" +
			"   du.id AS id," +
			"   e.name AS name," +
			"   du.pass AS pass" +
			" FROM dbuser du" +
			" INNER JOIN employee e" +
			"   ON du.id = e.id" +
			" WHERE du.id = ?" +
			" ORDER BY du.id ASC"; 
				
	private final String SQL_CREATE_USER =
			" INSERT INTO dbuser (id, pass) VALUES ( ?, ? )";
	
	private final String SQL_UPDATE_USER =
			" UPDATE dbuser SET pass = ? WHERE id = ?";

	private final String SQL_EXISTS_ID =
			"SELECT id FROM dbuser WHERE id = ?";
	
	public List<User> findAll() {
		List<User> userList = new ArrayList<>();
		
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				User user = getUser(rs);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}
	
	public User findUserById(String id) {
		User user = null;
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_USER_BY_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				user = getUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	public boolean create(User user) {
		try (Connection conn = DBConnect.connect()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt = conn.prepareStatement(SQL_CREATE_USER);) {
				pStmt.setString(1, user.getId());
				pStmt.setString(2, user.getPass());
				int result = pStmt.executeUpdate();
				if (result != 1) {
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
	
	public boolean update(User user) {
		try (Connection conn = DBConnect.connect()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pStmt = conn.prepareStatement(SQL_UPDATE_USER);) {
				pStmt.setString(1, user.getPass());
				pStmt.setString(2, user.getId());
				int result = pStmt.executeUpdate();
				if (result != 1) {
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
	
	public boolean isExistsById(String id) {
		try (Connection conn = DBConnect.connect()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_EXISTS_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	private User getUser(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		String pass = rs.getString("pass");
		User user = new User(id, name, pass);
		return user;
	}
}
