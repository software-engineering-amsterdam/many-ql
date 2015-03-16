package nl.uva.se.gui.widgets.questions;

import javafx.scene.control.Label;
import nl.uva.se.ql.ast.statement.Question;

public class UndefinedQuestion extends Label {
	private final Question question;

	public UndefinedQuestion(Question question) {
		super();
		this.question = question;
		this.setText("This question is undifined.");
		this.managedProperty().bind(this.visibleProperty()); 
		this.setVisible(false);
	}

	public Question getQuestion() {
		return this.question;
	}
}
