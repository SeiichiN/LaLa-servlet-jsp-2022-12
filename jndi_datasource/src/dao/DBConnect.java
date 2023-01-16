package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnect {
	
	static Connection connect() throws SQLException {
		DataSource ds = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/example_db");
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
		return ds.getConnection();
	}
}
