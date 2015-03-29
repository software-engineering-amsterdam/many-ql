package uva.TaxForm.AST.NodeCondition;

import java.util.LinkedList;

import uva.TaxForm.AST.Node;

public class NodeConditionIf extends NodeCondition {

	boolean expression = false;		//Not guilty, until proven guilty. Make a separate Class for it?
	
	public void add(Node node) {
		super.add(node);
	}
	
	public LinkedList<? extends Node> getNodes() {
		return super.getNodes();
	}
	
	public int getLevel() {
		return super.getLevel();
	}

	public void setLevel(int level) {
		super.setLevel(level);
	}
}
