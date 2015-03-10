package nl.uva.se.gui.elements;

import java.util.HashMap;

import nl.uva.se.ql.ast.statement.Condition;
import javafx.scene.layout.VBox;

public class ConditionBox extends VBox{
	
	Condition condition;
	HashMap<String, QuestionBox> questionBoxes;
	
	public ConditionBox(Condition condition){
		super();
		this.condition = condition;
		this.questionBoxes = new HashMap<String, QuestionBox>();
	}	
	
	public void addQuestionBox(QuestionBox questionBox)
	{
		questionBoxes.put(questionBox.getQuestion().getId(), questionBox);
	}
	
	public QuestionBox getQuestionBox(String id){
		return questionBoxes.get(id);
	}
	
	public HashMap<String, QuestionBox> getQuestionBoxes(){
		return questionBoxes;
	}
	
	public Condition getCondition(){
		return this.condition;
	}
}
