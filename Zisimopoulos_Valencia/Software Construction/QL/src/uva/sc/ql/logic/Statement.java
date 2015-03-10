package uva.sc.ql.logic;

import uva.sc.ql.ast.INode;
import uva.sc.ql.ast.INodeVisitor;

public abstract class Statement implements INode {

	public abstract <T> T accept(INodeVisitor<T> visitor);

}
