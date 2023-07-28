package com.dao;

import java.util.Vector;

import com.dto.BoardDTO;
import com.util.JDBCConnection;

public class BoardDAO extends JDBCConnection{

	public Vector<BoardDTO> selectAllBoard(){
		BoardDTO dto = null; 
		Vector<BoardDTO> vBoard = new Vector<>();
		
		String sql = "SELECT * FROM board WHERE is_reply = 0";
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			resultSet =pstmt.executeQuery();
			
			while(resultSet.next()) {
				dto = new BoardDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setUser_id(resultSet.getString("user_id"));
				dto.setIs_reply(resultSet.getBoolean("is_reply"));
				dto.setOrig_id(resultSet.getInt("orig_id"));
				dto.setContent(resultSet.getString("content"));
				dto.setCreated_at(resultSet.getTimestamp("created_at"));
				dto.setModified_at(resultSet.getTimestamp("modified_at"));
				dto.setOpen_reply(resultSet.getBoolean("open_reply"));
				
				vBoard.add(dto);
			}
		} catch (Exception e) {
			System.out.println("------------error in selectAllMember@BoardDAO---------------");
			e.printStackTrace();
		}
		
		// this.closeJDBCCOnnection(); Controller에서 닫기
		
		System.out.println("--------------vBoard size in BoardDAO return :" + vBoard.size() + "---------" );
		return vBoard;
	}
	
	public int createBoard(String user_id, String content) {
		Vector<BoardDTO> vBoard = new Vector<>();
		
		String sql = "INSERT INTO board (user_id, is_reply, content) VALUES(?, ?, ?)";
		int line = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, 1);
			pstmt.setString(3, content);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			line =pstmt.executeUpdate();
			
			if(line==1) {
				System.out.println("----새로운 board 글 생성------------");
			}else {
				System.out.println("---------error in createBoard@BoardDAO-------");
			}
		} catch (Exception e) {
			System.out.println("------------error in createBoard@BoardDAO---------------");
			e.printStackTrace();
		}
		
		// this.closeJDBCCOnnection(); Controller에서 닫기
		
		System.out.println("--------------vBoard size in BoardDAO return :" + vBoard.size() + "---------" );
		
		return 0;
	}
	
	public int deleteBoard(int board_id) {
		int line = 0;
		String sql = "DELETE FROM board WHERE id= ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);

			System.out.println("---------" + pstmt.toString() + "--------------------");
			line =pstmt.executeUpdate();
			
			if(line==1) {
				System.out.println("---- 해당 " + board_id + "번 글 삭제------------");
			}else {
				System.out.println("---------error in deleteBoard@BoardDAO-------");
			}
		} catch (Exception e) {
			System.out.println("------------error in deleteBoard@BoardDAO---------------");
			e.printStackTrace();
		}
		
		// controller 에서 닫는지 확인
		
		return line; // 실패면 0 return
	}
	
	public int updateBoard(int board_id, String content) {
		int line = 0;
		String sql = "Update board SET content = ? WHERE id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(2, board_id);
			pstmt.setString(1,  content);

			System.out.println("---------" + pstmt.toString() + "--------------------");
			line =pstmt.executeUpdate();
			
			if(line==1) {
				System.out.println("---- 해당 " + board_id + "번 글 수정 완료------------");
			}else {
				System.out.println("---------error in updateBoard@BoardDAO-------");
			}
		} catch (Exception e) {
			System.out.println("------------error in updateBoard@BoardDAO---------------");
			e.printStackTrace();
		}
		
		// controller 에서 닫는지 확인
		
		return line; // 실패면 0 return
	}
}
