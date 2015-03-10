package org.uva.qls;

import org.uva.ql.ast.Node;
import org.uva.utility.CodePosition;

public class BaseQLSNode implements Node {
	private final CodePosition pos;

	public BaseQLSNode(CodePosition pos) {
		this.pos = pos;
	}
}
