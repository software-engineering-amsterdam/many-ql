package ast;

public class Question {
	private ID questionID;
	private ID questionText;
	private ID questionType;
	
	
	public Question (ID questionID, ID questionText, ID questionType) {
		this.questionID = questionID;
		this.questionText = questionText;
		this.questionType = questionType;
	}	
	
	public ID getQuestionId(){
		return questionID;
	}
	
	public ID getQuestionText(){
		return questionText;
	}
	
	public ID getQuestionType(){
		return questionType;
	}
	
	public void setQuesionId(ID questionID) {
		this.questionID = questionID;
	}
	
	public void setQuesionText(ID questionText) {
		this.questionText = questionText;
	}
	
	public void setQuesionType(ID questionType) {
		this.questionType = questionType;
	}
	/*
	@Override
	public String toString() {
		return (this.questionID + this.questionText + this.questionType);
	}
	
	@Override
	public <T> T accept(IMainVisitor<T> visitor) {
		return visitor.visit(this);
	}
	*/
}
