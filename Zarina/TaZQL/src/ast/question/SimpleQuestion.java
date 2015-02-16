package ast.question;

import ast.expression.variables.Id;
import ast.type.TextType;
import ast.type.Type;

public abstract class SimpleQuestion extends Question {
	private Id questionID;
	private TextType questionText;
	private Type questionType;
	
	
	public SimpleQuestion (Id questionID, TextType questionText, Type questionType) {
		//super();
		this.questionID = questionID;
		this.questionText = questionText;
		this.questionType = questionType;
	}	
	
	public Id getQuestionId(){
		return questionID;
	}
	
	public TextType getQuestionText(){
		return questionText;
	}
	
	public Type getQuestionType(){
		return questionType;
	}
	
/*
	@Override
	public String toString() {
		return this.questionID + " \"" + this.questionText + "\" " + this.questionType ;
	}
	*/
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
