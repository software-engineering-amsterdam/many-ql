package uva.sc.qls.logic;

import uva.sc.qls.ast.INode;
import uva.sc.qls.ast.INodeVisitor;
import uva.sc.qls.atom.ID;

public class StyleProperty implements INode{

	ID id;

	public StyleProperty(ID id) {
		this.id = id;
	}
	
	public ID getId() {
		return id;
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		String result = "[StyleProperty]:\n\t";
		result += id.toString();
		return result;
	}
}
