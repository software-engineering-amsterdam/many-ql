package org.uva.sea.ql.encoders.ast.operator;

import org.uva.sea.ql.encoders.visitor.UnaryOperatorVisitor;

public class NotOperator implements UnaryOperator {

	@Override
	public <T> T accept(UnaryOperatorVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
