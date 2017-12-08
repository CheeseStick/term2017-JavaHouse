package com.javahouse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractDAO {
	private static final String DB_URL  = "127.0.0.1";
	private static final String DB_PORT = "3306";
	
	private static final String DB_NAME = "JavaHouse";
	private static final String DB_USER = "jsp_user";
	private static final String DB_PASS = "password";
	
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	public abstract void query() throws Exception;
	
	public final void init() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String databaseURL = "jdbc:mysql://" + DB_URL + ":" + DB_PORT + "/" + DB_NAME;
		conn = DriverManager.getConnection(databaseURL, DB_USER, DB_PASS);
	}
	
	public final void close() {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public final void execute() {
		try {
			init();
			query();
			close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
