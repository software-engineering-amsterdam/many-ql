package uva.TaxForm.Trash;

import java.util.LinkedList;

import uva.TaxForm.Utils.StringUtils;

public class Node {
	
	private String token;
	private int parentID;
	private int id;
	private int level;
	private LinkedList<Node> children;
	private String stringTree;

	public Node() {
		
		this.setToken( "" );
		this.setParentID( 0 );
		this.setID( 0 );
		this.setLevel( 0 );
		this.children = new LinkedList<Node>();
	}
	
	public Node(String token, int id) {
		
		this.setToken( token );
		this.setParentID( id );
		this.setID( id );
		this.setLevel( 0 );
		this.children = new LinkedList<Node>();
	}
	
	public Node(String token, int parentID, int id) {
		
		this.setToken( token );
		this.setParentID( parentID );
		this.setID( id );
		this.setLevel( 0 );
		this.children = new LinkedList<Node>();
	}
	
	public Node(String token, int parentID, int id, int level) {
		
		this.setToken( token );
		this.setParentID( parentID );
		this.setID( id );
		this.setLevel( level );
		this.children = new LinkedList<Node>();
	}
	
	/*public static void addNode(Node tree, Node node) {
		
		//System.out.println(tree.children.size());
		
		if ( tree.children.size() == 0 && tree.parentID == 0 && tree.token == "") {
			
			tree.setToken( node.token );
			tree.setParentID( node.parentID );
			tree.setID( node.id );
			tree.setLevel(0);
			
			System.out.println( StringUtils.repeat("\t", tree.getLevel()) + node.toString() );
		}
		else if( tree.children.size() == 0 && tree.parentID != 0 && tree.token != "" ) {
			
			//System.out.println(tree.getLevel());
			int level = tree.getLevel() + 1;
			tree.children.add( new Node( node.token, node.parentID, node.id, level ) );
			
			System.out.println( StringUtils.repeat("\t", level) + node.toString() );
		}
		else if( tree.children.size() != 0 && tree.parentID != 0 && tree.token != "" ) {
			
			LinkedList<Node> children = tree.getChildren();
			
			while( !children.isEmpty() ) {
				
				Node child = children.pop();
				
				if( child.getID() == node.getParentID() ) {
					
					//System.out.println(child.getLevel());
					//node.setLevel( child.getLevel() + 1 );
					int level = child.getLevel() + 1;
					child.children.add(node);
					System.out.println( StringUtils.repeat("\t", level) + node.toString() );
				}
			}
			//System.out.println( "No child - " + parent.id + " - " + node.id );
		}
	}*/

	public static void addNodes(Node root, LinkedList<Node> nodeStack) {
		
		System.out.println(root);
		
		while ( !nodeStack.isEmpty() ) {
			
			Node node = nodeStack.pop();
			
			if ( root.id == node.parentID ) {
				
				node.setLevel(root.getLevel() + 1);
				root.children.add(node);
				Node.addNodes(node, nodeStack);
			}
			else if ( root.id > node.parentID ) {
				
				node.setLevel(root.getLevel() - 1);
				root.children.add(node);
				Node.addNodes(node, nodeStack);
			}
		}
		
		//System.out.println(root.toString());
	}

	public String toString() {
		
		this.stringTree = StringUtils.repeat("\t", this.getLevel()) 
							+ this.getParentID() + " - " + this.getID() + " - " 
							+ this.getToken();
		
		while( !this.children.isEmpty() ) {

			this.stringTree += this.children.pop().toString();
		}
		
		return this.stringTree;
	}
	
	public LinkedList<Node> getChildren() {
		
		return this.children;
	}
	
	public boolean hasChild() {
		
		return (this.children.size() > 0) ? true : false;
	}
	
	public int getParentID() {
		
		return this.parentID;
	}
	
	public void setParentID( int id ) {
		
		this.parentID = id;
	}
	
	public int getID() {
		
		return this.id;
	}
	
	public void setID( int id ) {
		
		this.id = id;
	}
	
	public String getToken() {
		
		return this.token;
	}
	
	public void setToken( String token ) {
		
		this.token = token;
	}
	
	public int getLevel() {
		
		return this.level;
	}
	
	public void setLevel(int level) {
		
		this.level = level;
	}
}
