package nl.uva.se.ql.gui.widgets.boxes;

import nl.uva.se.ql.ast.statement.*;
import nl.uva.se.ql.gui.builders.CalculatedQuestionBuilder;
import nl.uva.se.ql.gui.builders.QuestionBuilder;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.widgets.questions.calculated.BaseCalculatedQuestion;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.uva.se.ql.gui.widgets.questions.*;

public class QuestionBox extends VBox {
	
	private final Question question;
	private final Mediator mediator;

	public QuestionBox(Question question, Mediator mediator) {
		this.question = question;
		this.mediator = mediator;
		addQuestion(question);
	}
	
	public QuestionBox(CalculatedQuestion question, Mediator mediator) {
		this.question = question;
		this.mediator = mediator;
		addQuestion(question);
	}

	public void addQuestion(Question question) {		
		//Add label to the QuestionBox
		Label title = new Label(question.getLabel());
		this.getChildren().add(title);
		
		//Add the widget to the QuestionBox
		BaseQuestion baseQuestion = question.getType().accept(new QuestionBuilder(question, mediator));
		this.getChildren().add(baseQuestion.getWidget());
	}
	
	public void addQuestion(CalculatedQuestion question) {			
		//Add the widget to the QuestionBox		
		BaseCalculatedQuestion baseQuestion = question.getType().accept(new CalculatedQuestionBuilder(question, mediator));
		this.getChildren().add(baseQuestion.getWidget());
	}
	
	public Question getQuestion(){
		return this.question;
	}	
}