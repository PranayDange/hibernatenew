package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;

	@OneToOne
	// this will genrate a foreign key column in Question table(this will work like
	// a join)
	@JoinColumn(name = "answer_id")
	// join column is used to name the column
	// if we use one tomany then we have to use list
	private Answer answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int questionId, String question, Answer answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
