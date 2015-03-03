package uva.sc.logic;

import uva.sc.ast.INode;
import uva.sc.ast.INodeVisitor;

public abstract class Statement implements INode{

	public abstract <T> T accept(INodeVisitor<T> visitor);
	
}
