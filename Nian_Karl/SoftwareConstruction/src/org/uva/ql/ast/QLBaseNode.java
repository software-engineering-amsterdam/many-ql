package org.uva.ql.ast;

import org.uva.ql.ast.QLNode;
import org.uva.utility.CodePosition;

public class QLBaseNode implements QLNode {
	private final CodePosition pos;

	public QLBaseNode(CodePosition pos) {
		this.pos = pos;
	}

	public CodePosition getPos() {
		return pos;
	}
}
