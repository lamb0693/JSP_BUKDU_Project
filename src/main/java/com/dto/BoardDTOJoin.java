package com.dto;

public class BoardDTOJoin extends BoardDTO{
	int replyNo;
	String user_name;

	public BoardDTOJoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
