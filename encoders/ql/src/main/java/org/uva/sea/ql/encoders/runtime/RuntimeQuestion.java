package org.uva.sea.ql.encoders.runtime;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.runtime.value.Value;

public class RuntimeQuestion {

	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}

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
		Object old = this.value;
		this.value = value;
		pcs.firePropertyChange("value", old, value);
		System.out.println(question.getName() + " " + value);
	}

	@Override
	public String toString() {
		return question + " " + value;
	}

	public Question getQuestion() {
		return question;
	}

}
