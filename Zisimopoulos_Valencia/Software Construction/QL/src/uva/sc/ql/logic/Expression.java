package uva.sc.ql.logic;

import uva.sc.ql.ast.INode;
import uva.sc.ql.ast.INodeVisitor;
import uva.sc.ql.types.Type;

public abstract class Expression implements INode {

	public abstract <T> T accept(INodeVisitor<T> visitor);

	public String getValue() {
		return null;
	}

	public Type getType() {
		return null;
	}

}
