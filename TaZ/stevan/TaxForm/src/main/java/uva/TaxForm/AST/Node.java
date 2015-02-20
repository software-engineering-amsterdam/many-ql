package uva.TaxForm.AST;

import java.util.LinkedList;
import uva.TaxForm.Utils.StringUtils;

public class Node {
	
	private LinkedList<Node> nodes = new LinkedList<Node>();
	private int level = 0;
	
	Node() {
		super();
	}
	
	public void add(Node node) {
		nodes.add(node);
	}
	
	public LinkedList<Node> getNodes() {
		return nodes;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public String toString() {
		String str = StringUtils.repeat("\t", level); 
		return str;
	}
	
	public String toString(String var) {
		String str = StringUtils.repeat("\t", level) + var; 
		return str;
	}
}
