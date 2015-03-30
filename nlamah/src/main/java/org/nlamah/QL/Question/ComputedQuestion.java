package org.nlamah.QL.Question;


public class ComputedQuestion extends Question {

	String computationExpression;
	
	public ComputedQuestion(String identifier, String label, String type, String computationExpression) {
		super(identifier, label, type);
		
		this.computationExpression = computationExpression;
	}
}
