package uva.TaxForm.AST;

public class NodeQuestion extends Node {
	
	private String label;
	private NodeVar var;
	private NodeExp exp;
	
	public String getName() {
		return this.var.getName();
	}

	public void setName(String name) {
		this.var.setName(name);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public NodeVar getVar() {
		return this.var;
	}

	public void setVar(NodeVar var) {
		this.var = var;
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

	public String toString() {
		return super.toString(this.getName() + " - " + var.toString());
	}
}
