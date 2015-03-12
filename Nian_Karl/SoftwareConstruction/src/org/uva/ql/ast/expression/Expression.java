package org.uva.ql.ast.expression;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitable;

public abstract class Expression extends BaseNode implements ExpressionVisitable {

	public Expression(CodePosition pos) {
		super(pos);
	}
	
	public abstract Type getType(TypeChecker typeChecker);
	
}
