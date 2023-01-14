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
	
	private User getUser(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		String pass = rs.getString("pass");
		User user = new User(id, name, pass);
		return user;
	}
}
