package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcDataSource;

/**
 * DataSourceオブジェクトを使った接続
 * @author Seiichi Nukayama
 * 
 * 参考
 * Class JdbcDataSource
 * http://www.h2database.com/javadoc/org/h2/jdbcx/JdbcDataSource.html
 * 
 * DataSource
 * https://docs.oracle.com/javase/jp/1.5.0/guide/jdbc/getstart/datasource.html
 * 
 * JNDI Datasource HOW-TO
 * https://tomcat.apache.org/tomcat-8.0-doc/jndi-datasource-examples-howto.html#Installation
 */
public class SelectEmployeeSample {

	public static void main(String[] args) {
		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL("jdbc:h2:tcp://localhost/~/example");
		ds.setUser("sa");
		ds.setPassword("");
		
		try (Connection conn = ds.getConnection()){			
			String sql = "SELECT id, name, age FROM employee";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.println("ID:" + id);
				System.out.println("名前:" + name);
				System.out.println("年齢:" + age);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
			
	}
}
