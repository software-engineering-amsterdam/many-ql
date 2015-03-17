package org.uva.ql.ast.expression;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public abstract class Expression extends BaseNode {
	public abstract <T> T accept(ExpressionVisitor<T> visitor);

	public Expression(CodePosition pos) {
		super(pos);
	}

	public abstract Type getType(TypeChecker typeChecker);

}
