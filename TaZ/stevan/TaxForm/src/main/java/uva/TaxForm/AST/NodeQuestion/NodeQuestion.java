package uva.TaxForm.AST.NodeQuestion;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeExp.Expression;

public class NodeQuestion extends Node {
	
	private String label;
	private Expression<?> exp;
	
	public boolean eval() {
		
		//Check 
		
		this.exp.getNodes().size();
		//TODO: Evaluate the question and give true/false back if question is valid/invalid
		return false;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getLevel() {
		return super.getLevel();
	}

	public void setLevel(int level) {
		super.setLevel(level);
	}
	
	public Expression<?> getExpression() {
		return this.exp;
	}

	public void setExpression(Expression<?> exp) {
		this.exp = exp;
	}
}
