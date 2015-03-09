package org.uva.qls.ast.literal;

import org.uva.qls.ast.QLSNode;
import org.uva.utility.CodePosition;

public class Literal implements QLSNode {

	private CodePosition position;
	
	public Literal(CodePosition position) {
		this.position = position;
	}
}
