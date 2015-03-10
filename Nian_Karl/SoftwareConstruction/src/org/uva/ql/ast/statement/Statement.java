package org.uva.ql.ast.statement;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.visitor.StatementVisitable;
import org.uva.utility.CodePosition;

public abstract class Statement extends BaseNode implements StatementVisitable {

	public Statement(CodePosition pos) {
		super(pos);
	}
}
