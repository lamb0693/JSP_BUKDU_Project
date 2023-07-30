package com.dto;

public class MemberDTOWithReply extends MemberDTO{
	private int reply_no;
	
	public MemberDTOWithReply(){
		super();
	}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	
}
