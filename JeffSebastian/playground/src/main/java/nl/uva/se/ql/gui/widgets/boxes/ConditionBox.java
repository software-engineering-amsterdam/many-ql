package nl.uva.se.ql.gui.widgets.boxes;

import javafx.scene.layout.VBox;
import nl.uva.se.ql.ast.statement.Condition;

public class ConditionBox extends VBox{
	
	Condition condition;
		
	public ConditionBox(Condition condition){
		super();
		this.condition = condition;	
		this.setVisible(false);
	}	
	
	public void addQuestionBox(QuestionBox questionBox)
	{		
		this.getChildren().add(questionBox);
	}	
	
	public Condition getCondition(){
		return this.condition;
	}	
}
