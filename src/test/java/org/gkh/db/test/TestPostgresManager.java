package org.gkh.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.gkh.csv.PostgresManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPostgresManager {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetConnection() {
		PostgresManager pm = new PostgresManager();
		try {
			Connection db = pm.getConnection();
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
	
	// PostgreSQL Documentation
	// Connecting to the Database
	// Chapter 3. Initializing the Driver
	// https://jdbc.postgresql.org/documentation/80/connect.html
	
	// The infamous java.sql.SQLException: No suitable driver found
	// http://stackoverflow.com/a/1911487/6146580
	@Test
	public void testPostgresDriver() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}
		
		// The URL must be of the form jdbc:postgresql://<host>:<port>/<database>
		String url = "jdbc:postgresql://localhost:5432/postgres";
		try {
			DriverManager.getConnection(url, "postgres", "postgres");
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
	}

}
