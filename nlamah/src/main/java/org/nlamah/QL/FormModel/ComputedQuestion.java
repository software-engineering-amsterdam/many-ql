package org.nlamah.QL.FormModel;



public class ComputedQuestion extends Question 
{
	private String computationExpression;
	
	public ComputedQuestion(String identifier, String label, String type, String computationExpression) 
	{
		super(identifier, label, type);
		
		this.computationExpression = computationExpression;
	}
	
	public String getComputationExpression()
	{
		return this.computationExpression;
	}
}
