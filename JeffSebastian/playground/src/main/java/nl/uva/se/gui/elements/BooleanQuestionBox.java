package nl.uva.se.gui.elements;

import nl.uva.se.ql.ast.statement.Question;
import javafx.scene.control.CheckBox;

public class BooleanQuestionBox extends CheckBox{
	
	private final Question question;
	
	public BooleanQuestionBox(Question question){
		super();
		this.question = question;
	}
	
	public Question getQuestion(){
		return this.question;
	}

}
