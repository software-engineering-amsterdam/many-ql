package org.uva.qls.ast.literal;

import org.uva.qls.ast.QLSNode;
import org.uva.qls.visitor.LiteralVisitable;
import org.uva.utility.CodePosition;

public abstract class Literal implements QLSNode, LiteralVisitable {

	private CodePosition position;
	
	public Literal(CodePosition position) {
		this.position = position;
	}
	
	public 
}
