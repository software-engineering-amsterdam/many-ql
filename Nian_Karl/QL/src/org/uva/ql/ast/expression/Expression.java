package org.uva.ql.ast.expression;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.type.ExpressionType;
import org.uva.ql.ast.type.QuestionType;

public abstract class Expression implements Node{
	
	public ExpressionType getExpressionType() {
		return ExpressionType.NO_TYPE;
	}
}
