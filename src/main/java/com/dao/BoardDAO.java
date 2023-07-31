package com.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.dto.BoardDTO;
import com.dto.BoardDTOJoin;
import com.util.JDBCConnection;

public class BoardDAO extends JDBCConnection{

	public Vector<BoardDTO> selectAllBoardJoin(int max, int offset){
		BoardDTO dto = null; 
		Vector<BoardDTO> vBoard = new Vector<>();
		
		String sql = "SELECT * FROM board WHERE is_reply = 0";
		if( max != -1) sql = sql + " LIMIT " + max;
		if( offset != -1) sql = sql + " OFFSET " + offset;
		
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
	
	public Vector<BoardDTOJoin> selectAllBoard(int max, int offset){
		BoardDTOJoin dto = null; 
		Vector<BoardDTOJoin> vBoard = new Vector<>();
		
		String sql = "SELECT board.*, member.name FROM board INNER JOIN member ON board.user_id = member.id WHERE board.is_reply = 0";
		if( max != -1) sql = sql + " LIMIT " + max;
		if( offset != -1) sql = sql + " OFFSET " + offset;
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			resultSet =pstmt.executeQuery();
			
			while(resultSet.next()) {
				dto = new BoardDTOJoin();
				dto.setId(resultSet.getInt("id"));
				dto.setUser_id(resultSet.getString("user_id"));
				dto.setIs_reply(resultSet.getBoolean("is_reply"));
				dto.setOrig_id(resultSet.getInt("orig_id"));
				dto.setContent(resultSet.getString("content"));
				dto.setCreated_at(resultSet.getTimestamp("created_at"));
				dto.setModified_at(resultSet.getTimestamp("modified_at"));
				dto.setUser_name("name");
												
				vBoard.add(dto);
			}
			// 하나씩 마다 댓글 갯수를 추가
			for(BoardDTOJoin board : vBoard) {
				sql = "SELECT COUNT(*) AS reply_no FROM board WHERE orig_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board.getId());
				resultSet = pstmt.executeQuery();
				resultSet.next();
				board.setReplyNo(resultSet.getInt("reply_no"));
			}
			
		} catch (Exception e) {
			System.out.println("------------error in selectAllMember@BoardDAO---------------");
			e.printStackTrace();
		}
		
		// this.closeJDBCCOnnection(); Controller에서 닫기
		
		System.out.println("--------------vBoard size in BoardDAO return :" + vBoard.size() + "---------" );
		return vBoard;
	}
	
	public Map< Integer, Vector<BoardDTO> > selectAllReply(){
		BoardDTO dto = null; 
		Vector<BoardDTO> vBoard = new Vector<>();
		Vector<Integer> vOrig = new Vector<>();
		Map< Integer, Vector<BoardDTO> > mapReply =  new HashMap<>();
		
		String sql = "SELECT orig_id FROM board WHERE is_reply = 1";
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("---------" + pstmt.toString() + "--------------------");
			resultSet =pstmt.executeQuery();
			
			while(resultSet.next()) {
				int orig_id = resultSet.getInt("orig_id");
				if( !vOrig.contains(orig_id) ) vOrig.add(orig_id);
			}
			
			for(int origId : vOrig) {
				sql = "SELECT * from board WHERE orig_id = ?" ;
				pstmt = con.prepareStatement(sql);	
				pstmt.setInt(1, origId);
				resultSet =pstmt.executeQuery();
				System.out.println("---------" + pstmt.toString() + "--------------------");
				
				vBoard = new Vector<>();
				while(resultSet.next()) {
					dto = new BoardDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setUser_id(resultSet.getString("user_id"));
					dto.setIs_reply(resultSet.getBoolean("is_reply"));
					dto.setOrig_id(resultSet.getInt("orig_id"));
					dto.setContent(resultSet.getString("content"));
					dto.setCreated_at(resultSet.getTimestamp("created_at"));
					dto.setModified_at(resultSet.getTimestamp("modified_at"));
					
					vBoard.add(dto);
				}
				
				System.out.println("--------원글 " + origId + " 댓글 수 " + vBoard.size() + " -----------");
				if(vBoard.size() == 0 ) continue;
				mapReply.put(origId, vBoard);
			}
			
			
		} catch (Exception e) {
			System.out.println("------------error in selectAllMember@BoardDAO---------------");
			e.printStackTrace();
		}
		
		// this.closeJDBCCOnnection(); Controller에서 닫기
		
		System.out.println("--------------vBoard size in BoardDAO return :" + vBoard.size() + "---------" );
		return mapReply;
	}
	
	public int createBoard(String user_id, String content) {
		Vector<BoardDTO> vBoard = new Vector<>();
		
		String sql = "INSERT INTO board (user_id, is_reply, content) VALUES(?, ?, ?)";
		int line = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, 0);
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
	
	public int createBoard(String user_id, String content, int orig_id) {
		Vector<BoardDTO> vBoard = new Vector<>();
		
		String sql = "INSERT INTO board (user_id, is_reply, content, orig_id) VALUES(?, ?, ?, ?)";
		int line = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, 1);
			pstmt.setString(3, content);
			pstmt.setInt(4,  orig_id);
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
