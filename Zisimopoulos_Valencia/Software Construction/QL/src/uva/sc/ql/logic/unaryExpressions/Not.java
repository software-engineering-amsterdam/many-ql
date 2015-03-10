package uva.sc.ql.logic.unaryExpressions;

import uva.sc.ql.ast.INodeVisitor;
import uva.sc.ql.logic.Expression;

public class Not extends UnaryExpression {

	public Not(Expression operand) {
		super(operand);
	}

	public String toString() {
		return "[un !]" + operand.getValue();
	}

	@Override
	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
