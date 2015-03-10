package uva.sc.ql.logic.unaryExpressions;

import uva.sc.ql.ast.INodeVisitor;
import uva.sc.ql.logic.Expression;

public class Minus extends UnaryExpression {

	public Minus(Expression operand) {
		super(operand);
	}

	public String toString() {
		return "[un -]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
