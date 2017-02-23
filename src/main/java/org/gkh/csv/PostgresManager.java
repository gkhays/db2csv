package org.gkh.csv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresManager {
	
	public void createDatabase() throws SQLException {
		String sql = "CREATE DATABASE devices OWNER postgres";
		Connection db = getConnection();
		Statement stmt = db.createStatement();
		
		stmt.execute(sql);
		stmt.close();
	}
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException c) {
			throw new SQLException("Cannot find database driver");
		}
		
		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
		Connection db = DriverManager.getConnection(jdbcUrl, "postgres", "postgres");
		
		// Properties props = new Properties();
		// props.setProperty("user", "dbauser");
		// props.setProperty("password", "n0v3ll");
		// props.setProperty("ssl", "false");
		// Connection conn = DriverManager.getConnection(jdbcUrl, props);
		return db;
	}
	
}
