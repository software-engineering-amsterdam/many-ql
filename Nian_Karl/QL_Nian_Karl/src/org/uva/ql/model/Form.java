package org.uva.ql.model;

import java.util.ArrayList;

public class Form {

	private ArrayList<Question> questions;
	
	public Form() {
		this.questions = new ArrayList<Question>(); 
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	
	public Question getQuestion(int i){
		if (i >= this.questions.size()) {
			throw new IndexOutOfBoundsException("Index " + i + " is out of bounds");
		}
		return this.questions.get(i);
	}
}
