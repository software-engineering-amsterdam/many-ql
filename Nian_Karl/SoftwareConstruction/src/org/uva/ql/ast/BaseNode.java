package org.uva.ql.ast;

import org.uva.utility.CodePosition;

public class BaseNode implements Node {
	private final CodePosition pos;

	public BaseNode() {
		this.pos = new CodePosition(0, 0);
	}
	
	public BaseNode(CodePosition pos) {
		this.pos = pos;
	}

	public CodePosition getPosition() {
		return pos;
	}
}
