/*
 * @Zarina
 */
package com.antlr4.zarina.tazql;


public class QuestionLabels {
	private int number;
	private String questionLabel;
	
	public QuestionLabels() {}
	
	public QuestionLabels(int number, String questionLabel){
		this.number = number;
		this.questionLabel = questionLabel;
	}
	
	@Override
	public String toString() {
		return (this.number + this.questionLabel);
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getQuestionLabel(){
		return questionLabel;
	}
	
	public void setQuestionLabel(String questionLabel) {
		this.questionLabel = questionLabel;
	}
}
