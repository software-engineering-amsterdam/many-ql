package uva.TaxForm.AST;

public class NodeExpArithmetic extends NodeExp  {

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
