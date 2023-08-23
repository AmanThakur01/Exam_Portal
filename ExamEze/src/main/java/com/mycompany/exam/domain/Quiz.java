package com.mycompany.exam.domain;

public class Quiz {
	private int qid;
	private String title;
	private String description;
	private int max_marks;
	private int no_of_que;
	private int status;
	private int cid;

	public Quiz() {

	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getMax_marks() {
		return max_marks;
	}

	public void setMax_marks(int max_marks) {
		this.max_marks = max_marks;
	}

	public int getNo_of_que() {
		return no_of_que;
	}

	public void setNo_of_que(int no_of_que) {
		this.no_of_que = no_of_que;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCid() {
		return qid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Quiz(int qid, String title, String description, int max_marks, int no_of_que, int status, int cid) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.max_marks = max_marks;
		this.no_of_que = no_of_que;
		this.status = status;
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
