package uva.TaxForm.AST.NodeQuestion;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeExp.NodeExp;

public class NodeQuestion extends Node {
	
	private String label;
	private NodeExp exp;
	
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
	
	public NodeExp getExpression() {
		return this.exp;
	}

	public void setExpression(NodeExp exp) {
		this.exp = exp;
	}
}
