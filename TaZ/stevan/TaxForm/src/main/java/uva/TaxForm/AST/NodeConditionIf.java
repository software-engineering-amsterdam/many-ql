package uva.TaxForm.AST;

import java.util.LinkedList;

public class NodeConditionIf extends NodeCondition {

	boolean expression = false;		//Not guilty, until proven guilty. Make a separate Class for it?
	
	public void add(Node node) {
		super.add(node);
	}
	
	public LinkedList<Node> getNodes() {
		return super.getNodes();
	}
	
	public int getLevel() {
		return super.getLevel();
	}

	public void setLevel(int level) {
		super.setLevel(level);
	}
}
