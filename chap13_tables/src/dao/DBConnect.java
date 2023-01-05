package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	static final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/dbsample";
	static final String DB_USER = "sa";
	static final String DB_PASS = "";
	
	static Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS);
		return conn;
	}
	
}
