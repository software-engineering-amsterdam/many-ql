package nl.uva.se.ql.gui.widgets.boxes;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.listeners.IMediator;

public class CalculatedBox extends VBox{	
	private final Label label;
	private final CalculatedQuestion question;
	
	public CalculatedBox(CalculatedQuestion question, IMediator mediator) {		
		this.label = new Label();
		this.question = question;
		this.getChildren().add(label);
	}
	
	public CalculatedQuestion getCalculatedQuestion(){
		return this.question;
	}
	
	public void setValue(Value value){
		label.setText(question.getId() + ": " + value.getValue().toString());
		System.out.println("test: " + label.getText());
	}
}
