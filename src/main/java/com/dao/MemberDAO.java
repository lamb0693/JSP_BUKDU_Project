package com.dao;

import java.util.Vector;
import com.dto.MemberDTO;

import com.util.JDBCConnection;

public class MemberDAO extends JDBCConnection{
	
	public MemberDAO(){
		super();
	}
	
	// return all member using Vector
	public Vector<MemberDTO> selectAllMember(){
		MemberDTO dto = new MemberDTO();
		Vector<MemberDTO> vMember = new Vector<>();
		
		String sql = "SELECT * FROM member";
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			resultSet =pstmt.executeQuery();
			
			if(resultSet.next()) {
				dto.setId( Integer.parseInt(resultSet.getString("id")) );
				dto.setPassword( resultSet.getString("password") );
				dto.setName( resultSet.getString("name") );
				dto.setTel(resultSet.getString("tel"));
				dto.setJoin_date(resultSet.getTimestamp("join_date"));
				
				vMember.add(dto);
			}
		} catch (Exception e) {
			System.out.println("------------error in getUserDTO---------------");
			e.printStackTrace();
		}
				
		return vMember;
	}
	
}
