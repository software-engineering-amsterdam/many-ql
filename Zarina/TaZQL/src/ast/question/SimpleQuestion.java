package ast.question;

import ast.type.Id;
import ast.type.Text;
import ast.type.Type;

public abstract class SimpleQuestion extends Questions {
	private Id questionID;
	private Text questionText;
	private Type questionType;
	
	
	public SimpleQuestion (Id questionID, Text questionText, Type questionType) {
		super();
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
	public String toString() {
		return "ID: " + this.questionID + " Text: " + this.questionText + " Type: " + this.questionType ;
	}
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
