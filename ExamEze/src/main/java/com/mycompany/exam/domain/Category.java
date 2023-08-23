package com.mycompany.exam.domain;

public class Category {
	private int cid;
	private String title;
	private String description;
	
	public Category(){
		
	}
	
	public Category(int cid, String title, String description) {
		this.cid = cid;
		this.title = title;
		this.description = description;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
