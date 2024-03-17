package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import db.DBConnection.DBClose;

public class LoginDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public boolean isMemberExists (String userId) {
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		try {
			// db연결하기
			conn = DBConnection.getConnection();
			// sql 받을 상태 준비
			pstmt = conn.prepareStatement(sql);
			// ?에 값 넣기
			pstmt.setString(1, userId);
			// executeQuery로 쿼리실행 후 rs로 결과값 받기
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString(1));
				return rs.getString(1).length() > 0;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return false; // 회원존재x
	}
	
	// 사용자에게 입력받은 회원정보가 데이터 베이스에 이미 존재하는지 여부 확인
//		public boolean isMemberExists(String id) {
//			String sql = "SELECT COUNT(*) FROM member WHERE USER_ID = ?";
//			try {
//				conn = DBConnection.getConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, id);
//				rs = pstmt.executeQuery();
//
//				if (rs.next()) {
//					return rs.getInt(1) > 0; // 결과가 1 이상이면 이미 회원이 존재함
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				DBClose.close(conn, pstmt, rs);
//			}
//
//			return false; // 회원이 존재하지 않음
//		}

}

