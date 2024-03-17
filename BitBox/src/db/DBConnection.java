package db;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
	    Connection conn = null;
	    
	    final String url = "jdbc:mysql://127.0.0.1:3306/test";
	    final String user = "root";
	    final String password = "1234";
	    
	    try {
	        conn = DriverManager.getConnection(url, user, password);
	        System.out.println("DB 연결 성공");
	    } catch (SQLException e) {
	        System.out.println("DB 연결 오류");
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public class DBClose {
	    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
	        try {
	            if(conn != null) {
	                conn.close();
	            }
	            if(pstmt != null) {
	                pstmt.close();
	            }
	            if(rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
