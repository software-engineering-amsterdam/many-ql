package org.uva.qls;

import org.uva.ql.ast.QLNode;
import org.uva.utility.CodePosition;

public class BaseQLSNode implements QLNode {
	private final CodePosition pos;

	public BaseQLSNode(CodePosition pos) {
		this.pos = pos;
	}
}
