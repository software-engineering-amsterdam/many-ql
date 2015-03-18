package nl.uva.se.ql.gui.widgets.boxes;

import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.gui.builders.QuestionBuilder;
import nl.uva.se.ql.gui.listeners.IMediator;
import nl.uva.se.ql.gui.widgets.questions.BaseQuestion;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CalculatedBox extends VBox{	
	private final IMediator mediator;
	private BaseQuestion baseQuestion;
	
	public CalculatedBox(CalculatedQuestion question, IMediator mediator) {		
		this.mediator = mediator;
		addQuestion(question);
	}

	public void addQuestion(CalculatedQuestion question) {		
		//Add label to the CalculatedBox
		Label title = new Label(question.getLabel());
		this.getChildren().add(title);
		
		//Add the widget to the CalculatedBox		
		this.baseQuestion = question.getType().accept(new QuestionBuilder(question, mediator));
		Node node = baseQuestion.getWidget();		
		node.setDisable(true);
		this.getChildren().add(node);
	}
	
	public BaseQuestion getBaseQuestion(){
		return this.baseQuestion;
	}	
}
