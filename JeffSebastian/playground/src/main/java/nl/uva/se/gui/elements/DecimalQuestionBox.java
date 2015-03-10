package nl.uva.se.gui.elements;

import nl.uva.se.ast.statement.Question;
import javafx.scene.control.TextField;

public class DecimalQuestionBox extends TextField {

	private final Question question;

	public DecimalQuestionBox(Question question) {
		super();
		this.question = question;
	}

	public Question getQuestion() {
		return question;
	}	
}
