package org.uva.sea.ql.encoders.runtime;

import java.util.Observable;

import org.uva.sea.ql.encoders.ast.Question;

public class RuntimeQuestion extends Observable {

	private final Question question;

	private Object value;

	public RuntimeQuestion(Question question, Object value) {
		this.question = question;
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
		setChanged();
		notifyObservers(value);
		System.out.println(question.getName() + " " + value);
	}

	public Question getQuestion() {
		return question;
	}

}
