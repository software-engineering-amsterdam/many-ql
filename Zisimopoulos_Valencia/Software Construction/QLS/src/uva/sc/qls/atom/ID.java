package uva.sc.qls.atom;

import uva.sc.qls.ast.INode;
import uva.sc.qls.ast.INodeVisitor;

public class ID implements INode{
	
	String value;

	public ID(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public String toString(){
		return "[ID]: " + this.value;
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
