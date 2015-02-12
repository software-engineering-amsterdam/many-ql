package ast;

import ast.type.Id;
import ast.type.Text;
import ast.type.Type;

public abstract class Question extends FormSection {
	private Id questionID;
	private Text questionText;
	private Type questionType;
	
	
	public Question (Id questionID, Text questionText, Type questionType) {
		this.questionID = questionID;
		this.questionText = questionText;
		this.questionType = questionType;
	}	
	
	public Id getQuestionId(){
		return questionID;
	}
	
	public Text getQuestionText(){
		return questionText;
	}
	
	public Type getQuestionType(){
		return questionType;
	}
	
	
	@Override
	public <T> T accept(IMainVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
