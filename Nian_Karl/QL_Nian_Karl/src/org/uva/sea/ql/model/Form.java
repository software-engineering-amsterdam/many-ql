package org.uva.sea.ql.model;

import java.util.ArrayList;

public class Form {
	private ArrayList<Question> questions;

	public Form() {
		this.questions = new ArrayList<Question>();
	}

	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	
	public Question getQuestion(int i) {
		if (i >= this.questions.size()) {
			throw new IndexOutOfBoundsException("Index out of bound on " + i + " with size: " + this.questions.size());
		}
		return this.questions.get(i);
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
}
