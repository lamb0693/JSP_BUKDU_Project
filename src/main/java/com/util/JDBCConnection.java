package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {
	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet resultSet;
	
	public JDBCConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			String url = "jdbc:mysql://192.168.200.185:3306/my_db";
			String id = "root";
			String pwd = "ehddnrdl";
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("----------db 연결 성공------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeJDBCCOnnection() {
		try {
			if(resultSet!= null) resultSet.close();
			if(stmt!=null) stmt.close();
			if(pstmt!= null) pstmt.close();
			if(con != null) con.close();
			
			System.out.println("----------JDBC 자원 해제 성공------------");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}


