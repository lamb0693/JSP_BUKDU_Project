package com.dto;

import java.sql.Timestamp;

public class BoardDTO {
	private int id;
	private String user_id;
	private boolean is_reply;
	private int orig_id;
	private String content;
	private Timestamp created_at;
	private Timestamp modified_at;
	private boolean open_reply;
	
	public BoardDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public boolean isIs_reply() {
		return is_reply;
	}

	public void setIs_reply(boolean is_reply) {
		this.is_reply = is_reply;
	}

	public int getOrig_id() {
		return orig_id;
	}

	public void setOrig_id(int orig_id) {
		this.orig_id = orig_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getModified_at() {
		return modified_at;
	}

	public void setModified_at(Timestamp modified_at) {
		this.modified_at = modified_at;
	}

	public boolean isOpen_reply() {
		return open_reply;
	}

	public void setOpen_reply(boolean open_reply) {
		this.open_reply = open_reply;
	}
	
	
		
}
