package org.uva.ql.ast.statement;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.visitor.StatementVisitor;

public abstract class Statement extends BaseNode {
	public abstract <T> T accept(StatementVisitor<T> visitor);

	public Statement(CodePosition pos) {
		super(pos);
	}
}
