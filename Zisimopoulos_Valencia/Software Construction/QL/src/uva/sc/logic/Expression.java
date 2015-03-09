package uva.sc.logic;

import uva.sc.ast.INode;
import uva.sc.ast.INodeVisitor;
import uva.sc.types.Type;

public abstract class Expression implements INode{
	
	public abstract <T> T accept(INodeVisitor<T> visitor);

	public String getValue(){ return null; }
	
	public Type getType(){ return null; }

}
