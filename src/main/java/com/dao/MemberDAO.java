package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import com.dto.MemberDTO;
import com.util.JDBCConnection;
import com.util.MyPasswordEncoder;

public class MemberDAO extends JDBCConnection{
	
	public MemberDAO(){
		super();
	}
	
	// return all member using Vector
	public Vector<MemberDTO> selectAllMember(){
		MemberDTO dto = null; 
		Vector<MemberDTO> vMember = new Vector<>();
		
		String sql = "SELECT * FROM member";
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			resultSet =pstmt.executeQuery();
			
			while(resultSet.next()) {
				dto = new MemberDTO();
				dto.setId( resultSet.getString("id"));
				dto.setPassword( resultSet.getString("password") );
				dto.setName( resultSet.getString("name") );
				dto.setTel(resultSet.getString("tel"));
				dto.setIsadmin( resultSet.getBoolean("isadmin"));
				dto.setJoin_date(resultSet.getTimestamp("join_date"));
				
				vMember.add(dto);
			}
		} catch (Exception e) {
			System.out.println("------------error in getUserDTO---------------");
			e.printStackTrace();
		}
		
		//this.closeJDBCCOnnection();  Controller 에서 닫자
		
		System.out.println("--------------vMember size in MemberDAO return :" + vMember.size() + "---------" );
		return vMember;
	}
	
	
	// Create name, password name tel
	public String createMember(String id, String password, String name, String tel){
		
		String sql = "INSERT INTO member (id, password, name, tel) " 
				  + "VALUES (?, ? ,?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			int lineUpdated =pstmt.executeUpdate();
			this.closeJDBCCOnnection();
			
			if(lineUpdated == 1) {
				return "새 사용자로 등록 되었습니다";
			} else {
				System.out.println("==========error in MEMBERDAO:CreateMember============");
				return "System 오류입니다";
			}
			
		} catch (SQLException e) {
			System.out.println("------------error in getUserDTO---------------");
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
	public String createMember(String id, String password, String name, String tel, Timestamp join_date){
		
		String sql = "INSERT INTO member (id, password, name, tel, join_date) " 
				  + "VALUES (?, ? ,?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setTimestamp(5, join_date);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			int lineUpdated =pstmt.executeUpdate();
			this.closeJDBCCOnnection();
			
			if(lineUpdated == 1) {
				return "새 사용자로 등록 되었습니다";
			} else {
				System.out.println("==========error in MEMBERDAO:CreateMember============");
				return "ERROR";
			}
			
		} catch (SQLException e) {
			System.out.println("------------error in getUserDTO---------------");
			e.printStackTrace();
			return e.getMessage();
		}

	}
	
	public String updateMember(String id, String password, String name, String tel){
		
		String sql = "Update member SET password=?, name=?, tel=? " 
				  + " WHERE id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, id);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			int lineUpdated =pstmt.executeUpdate();
			this.closeJDBCCOnnection();
			
			if(lineUpdated == 1) {
				return "개인정보가 수정되었습니다";
			} else {
				System.out.println("==========error in MEMBERDAO:updateMember============");
				return "ERROR";
			}
			
		} catch (SQLException e) {
			System.out.println("------------error in getUserDTO---------------");
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
	// login 성공하면 dto return 실패하면 null return
	public MemberDTO checkLogin(String id, String password) {
		MemberDTO dto = new MemberDTO();
		
		String sql = "SELECT * FROM member WHERE id = ? AND password = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			String hashedPassword = MyPasswordEncoder.hashPassword(password);
			pstmt.setString(2, hashedPassword);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			resultSet =pstmt.executeQuery();
			
			while(resultSet.next()) {
				dto = new MemberDTO();
				dto.setId( resultSet.getString("id"));
				dto.setPassword( resultSet.getString("password") );
				dto.setName( resultSet.getString("name") );
				dto.setTel(resultSet.getString("tel"));
				dto.setIsadmin( resultSet.getBoolean("isadmin"));
				dto.setJoin_date(resultSet.getTimestamp("join_date"));
				
				this.closeJDBCCOnnection();
				
				System.out.println("--------------MemberDAO return  MemberDTO :" + dto.getId() + "---------" );
				return dto;
			}
		} catch (Exception e) {
			System.out.println("------------error in getUserDTO---------------");
			e.printStackTrace();
			return null;
		}
		
		this.closeJDBCCOnnection();
		
		System.out.println("----------MemberDAO --Login Fail ---------" );
		return null;
		
	}
	
}
