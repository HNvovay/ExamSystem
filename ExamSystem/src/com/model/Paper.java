package com.model;

public class Paper {
	private int id;
	private String paperName;
	private String schoose_id;
	private String mchoose_id;
	private String judge_id;
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getSchoose_id() {
		return schoose_id;
	}
	public void setSchoose_id(String schoose_id) {
		this.schoose_id = schoose_id;
	}
	public String getMchoose_id() {
		return mchoose_id;
	}
	public void setMchoose_id(String mchoose_id) {
		this.mchoose_id = mchoose_id;
	}
	public String getJudge_id() {
		return judge_id;
	}
	public void setJudge_id(String judge_id) {
		this.judge_id = judge_id;
	}
	
	public Paper() {
		super();
	}
	public Paper(String paperName, String schoose_id, String mchoose_id, String judge_id, String state) {
		super();
		this.paperName = paperName;
		this.schoose_id = schoose_id;
		this.mchoose_id = mchoose_id;
		this.judge_id = judge_id;
		this.state = state;
	}
	
	
}
