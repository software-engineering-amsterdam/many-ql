package nl.uva.sc.encoders.ql.ast.operator;

import nl.uva.sc.encoders.ql.visitor.UnaryOperatorVisitor;

public class NotOperator implements UnaryOperator {

	@Override
	public <T> T accept(UnaryOperatorVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
