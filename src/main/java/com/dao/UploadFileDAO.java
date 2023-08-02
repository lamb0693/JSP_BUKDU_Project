package com.dao;

import java.sql.SQLException;
import java.util.Vector;

import com.dto.UploadFileDTO;
import com.util.JDBCConnection;

public class UploadFileDAO extends JDBCConnection{

	public UploadFileDAO() {
		
	}
	
	public Vector<UploadFileDTO> selectAllFiles(int max, int off) {
		Vector<UploadFileDTO> vFiles = new Vector<>();
		UploadFileDTO dto = null;

		String sql = "SELECT * FROM upload LIMIT ? OFFSET ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			if(max == -1) max=12;
			pstmt.setInt(1, max);
			if(off ==-1) off=0;
			pstmt.setInt(2, off);
			System.out.println(pstmt.toString());
			resultSet = pstmt.executeQuery();
	
			while(resultSet.next()) {
				dto = new UploadFileDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setOrig_fn(resultSet.getString("orig_fn"));
				dto.setSaved_fn(resultSet.getString("saved_fn"));
				dto.setUser_id(resultSet.getString("user_id"));
				dto.setFilelength(resultSet.getLong("filelength"));
				dto.setUploaded_at(resultSet.getTimestamp("uploaded_at"));
				
				vFiles.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("------------error in getUserDTO---------------");
			e.printStackTrace();
		}				
		return vFiles;
	}
	
	public int createFileBoard(String orig_fn, String saved_fn, String user_id, long filelength) {
		int retValue = -1;
		
		String sql = "INSERT INTO upload (orig_fn, saved_fn, user_id, filelength) VALUES(?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, orig_fn);
			pstmt.setString(2,  saved_fn);
			pstmt.setString(3,  user_id);
			pstmt.setLong(4,  filelength);
			
			retValue = pstmt.executeUpdate();
			
			if(retValue==1) {
				System.out.println("----새로운 upload 파일 생성------------");
			}else {
				System.out.println("---------error in createBoard@BoardDAO-------");
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("------------error in createFile@DAO---------------");
			e.printStackTrace();
		}
		
		return retValue;
	}
}
