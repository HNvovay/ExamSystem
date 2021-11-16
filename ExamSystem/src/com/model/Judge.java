package com.model;

public class Judge {
	private Integer id;
	private String questionText;
	private int answer;
	private String score;
	public Judge() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public Judge(String questionText, int answer, String score) {
		super();
		this.questionText = questionText;
		this.answer = answer;
		this.score = score;
	}
	public Judge(Integer id, String questionText, int answer, String score) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.answer = answer;
		this.score = score;
	}
	
	
}
