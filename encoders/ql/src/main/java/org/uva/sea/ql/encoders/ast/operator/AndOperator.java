package org.uva.sea.ql.encoders.ast.operator;

import org.uva.sea.ql.encoders.visitor.BinaryOperatorVisitor;

public class AndOperator implements BinaryOperator {

	@Override
	public <T> T accept(BinaryOperatorVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
