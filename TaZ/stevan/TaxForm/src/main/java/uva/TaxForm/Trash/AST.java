package uva.TaxForm.Trash;

import java.util.LinkedList;

public class AST {

	private Node tree = new Node();
	
	public AST( LinkedList<Node> nodeStack ) {
		
		this.tree = nodeStack.pop();
		Node.addNodes(this.tree, nodeStack);
		
	}
	
	public String toString() {
		
		return this.tree.toString();
	}
}
