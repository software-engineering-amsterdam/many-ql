package uva.TaxForm.AST;

import java.util.LinkedList;

public class Node {
	
	private LinkedList<Node> nodes = new LinkedList<Node>();
	
	Node() {
		super();
	}
	
	public void add(Node node) {
		nodes.add(node);
	}
	
	public LinkedList<Node> getNodes() {
		return nodes;
	}
}
