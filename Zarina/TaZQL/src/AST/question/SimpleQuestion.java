package ast.question;

import ast.type.Type;

public class SimpleQuestion extends Question {
	private final String questionID;
	private final String questionText;
	private final Type questionType;
	
	
	public SimpleQuestion (String questionID, String questionText, Type questionType) {
		this.questionID = questionID;
		this.questionText = questionText;
		this.questionType = questionType;
	}	
	
	public String getQuestionId(){
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
		return this.questionID + " \"" + this.questionText + "\" " + this.questionType.toString() ;
	}
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
