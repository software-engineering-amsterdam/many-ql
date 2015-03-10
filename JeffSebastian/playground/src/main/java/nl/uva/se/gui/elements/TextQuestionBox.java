package nl.uva.se.gui.elements;

import nl.uva.se.ql.ast.statement.Question;
import javafx.scene.control.TextField;

public class TextQuestionBox extends TextField {
	
private final Question question;
	
	public TextQuestionBox(Question question){
		super();
		this.question = question;
	}
	
	public Question getQuestion()
	{		
		return this.question;
	}

}
