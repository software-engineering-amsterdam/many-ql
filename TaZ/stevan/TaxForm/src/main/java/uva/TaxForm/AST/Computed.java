package uva.TaxForm.AST;

import java.util.LinkedList;

public class Computed extends Node {

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
