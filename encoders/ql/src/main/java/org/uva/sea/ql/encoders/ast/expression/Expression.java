package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.AstNode;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.visitor.ExpressionVisitor;

public abstract class Expression extends AstNode {

	public Expression(TextLocation textLocation) {
		super(textLocation);
	}

	public abstract <T> T accept(ExpressionVisitor<T> visitor);
}
