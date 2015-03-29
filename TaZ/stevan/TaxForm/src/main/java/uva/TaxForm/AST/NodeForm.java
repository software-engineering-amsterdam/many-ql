package uva.TaxForm.AST;

import java.util.LinkedList;

public class NodeForm extends Node {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void add(Node node) {
		super.add(node);
	}
	
	public LinkedList<? extends Node> getNodes() {
		return super.getNodes();
	}
}
