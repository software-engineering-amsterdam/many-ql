package nl.uva.se.ast;

import java.util.Collections;
import java.util.List;

public abstract class Node<T> {

	private List<T> children;

	public Node() {
		children = Collections.<T>emptyList();
	}
	
	public Node(List<T> children) {
		this.children = children;
	}

	public List<T> getChildren() {
		return children;
	}
	
	public boolean hasChildren() {
		return children.size() > 0;
	}

}
