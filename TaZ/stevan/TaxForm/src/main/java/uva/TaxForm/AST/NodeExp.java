package uva.TaxForm.AST;

import java.util.LinkedList;

public class NodeExp extends Node {
	
	public boolean eval() {
		
		//TODO: Evaluate the expression and give true/false back if expression is valid/invalid
		return false;
	}
	
	public void add(Node node) {
		super.add(node);
	}
	
	public LinkedList<Node> getNodes() {
		return super.getNodes();
	}
}
