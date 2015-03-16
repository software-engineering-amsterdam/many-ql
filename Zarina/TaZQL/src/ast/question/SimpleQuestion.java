package ast.question;

import ast.expression.variables.Id;
import ast.type.Type;

public class SimpleQuestion extends Question {
	private final Id ID;
	private final String TEXT;
	private final Type TYPE;
	
	
	public SimpleQuestion (Id questionID, String questionText, Type questionType) {
		this.ID = questionID;
		this.TEXT = questionText;
		this.TYPE = questionType;
	}	
	
	public Id getQuestionId(){
		return ID;
	}
	
	public String getQuestionText(){
		return TEXT;
	}
	
	public Type getQuestionType(){
		return TYPE;
	}
	

	@Override
	public String toString() {
		return this.ID.toString() + " \"" + this.TEXT + "\" " + this.TYPE.toString() ;
	}
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
