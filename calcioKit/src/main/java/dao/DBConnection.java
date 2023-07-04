package dao;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnection {
	private static final String DB_PASSWORD = "root";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/calciokitdb";
	private static final String DB_USER = "root";

	public static DataSource getDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL(DB_URL);
		dataSource.setUser(DB_USER);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}
}