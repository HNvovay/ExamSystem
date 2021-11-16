package com.model;

public class Mchoose {
	private Integer id;
	private String questionText;
	private String answer;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String score;
	public Mchoose() {
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Mchoose(String questionText, String answer, String optionA, String optionB, String optionC, String optionD,
			String score) {
		super();
		this.questionText = questionText;
		this.answer = answer;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.score = score;
	}
	public Mchoose(Integer id, String questionText, String answer, String optionA, String optionB, String optionC,
			String optionD, String score) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.answer = answer;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.score = score;
	}
	
	
}
