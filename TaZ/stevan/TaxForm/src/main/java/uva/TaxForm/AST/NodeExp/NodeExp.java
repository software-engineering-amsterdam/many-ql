package uva.TaxForm.AST.NodeExp;

import java.util.LinkedList;

import uva.TaxForm.AST.Node;

public class NodeExp extends Node {

	NodeExp() {
		super();
		// TODO Auto-generated constructor stub
	}

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
