package ast.question;

import ast.expression.variables.Id;
import ast.type.Type;

public class SimpleQuestion extends Question {
	private final Id questionID;
	private final String questionText;
	private final Type questionType;
	
	
	public SimpleQuestion (Id questionID, String questionText, Type questionType) {
		this.questionID = questionID;
		this.questionText = questionText;
		this.questionType = questionType;
	}	
	
	public Id getQuestionId(){
		return questionID;
	}
	
	public String getQuestionText(){
		return questionText;
	}
	
	public Type getQuestionType(){
		return questionType;
	}
	

	@Override
	public String toString() {
		return this.questionID.toString() + " \"" + this.questionText + "\" " + this.questionType.toString() ;
	}
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
