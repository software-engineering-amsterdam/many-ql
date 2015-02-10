package nl.uva.se.ast;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private TreeNode node;
	private List<TreeNode> children;
	
	public Tree(TreeNode node) {
		this.node = node;
		children = new ArrayList<TreeNode>();
	}
	
	public Tree(TreeNode node, List<TreeNode> children) {
		this.node = node;
		this.children = children;
	}

	public TreeNode getNode() {
		return node;
	}

	public List<TreeNode> getChildren() {
		return children;
	}
	
	public void addChild(TreeNode child) {
		children.add(child);
	}
	
	public int getNumberOfChildren() {
		return children.size();
	}
}
