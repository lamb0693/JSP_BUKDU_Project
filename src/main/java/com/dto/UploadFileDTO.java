package com.dto;

import java.sql.Timestamp;

public class UploadFileDTO {
	int id;
	String user_id;
	String orig_fn;
	String saved_fn;
	long filelength;
	Timestamp uploaded_at;

	public UploadFileDTO() {
		
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

	public String getOrig_fn() {
		return orig_fn;
	}

	public void setOrig_fn(String orig_fn) {
		this.orig_fn = orig_fn;
	}

	public String getSaved_fn() {
		return saved_fn;
	}

	public void setSaved_fn(String saved_fn) {
		this.saved_fn = saved_fn;
	}

	public long getFilelength() {
		return filelength;
	}

	public void setFilelength(long filelength) {
		this.filelength = filelength;
	}

	public Timestamp getUploaded_at() {
		return uploaded_at;
	}

	public void setUploaded_at(Timestamp uploaded_at) {
		this.uploaded_at = uploaded_at;
	}
	
}

