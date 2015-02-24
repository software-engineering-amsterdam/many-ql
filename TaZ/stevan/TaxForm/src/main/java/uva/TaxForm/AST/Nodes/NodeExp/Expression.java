package uva.TaxForm.AST.Nodes.NodeExp;

import uva.TaxForm.AST.Nodes.Node;

public class Expression<T> extends NodeExp  {

	private String operator;
	
	public void add(Node node) {
		super.add(node);
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
