package org.uva.sea.ql.encoders.runtime;

import java.util.Observable;

import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.runtime.value.Value;

public class RuntimeQuestion extends Observable {

	private final Question question;

	private Value value;

	public RuntimeQuestion(Question question, Value value) {
		this.question = question;
		this.value = value;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
		setChanged();
		notifyObservers(value);
		System.out.println(question.getName() + " " + value);
	}

	public Question getQuestion() {
		return question;
	}

}
