package uva.sc.ast;

import java.util.ArrayList;
import java.util.List;

public class NodeTree<T> {

	T value;
	NodeTree<T> parent;
	List<NodeTree<T>> children;
	
	public NodeTree(T value) {
		this.value = value;
		this.children = new ArrayList<NodeTree<T>>();
	}
	
	public NodeTree<T> addChild(T child) {
		NodeTree<T> childNode = new NodeTree<T>(child);
		childNode.parent = this;
		this.children.add(childNode);
		return childNode;
	}
	
}
