package uva.sc.ql.logic.binaryExpressions;

import uva.sc.ql.ast.INodeVisitor;
import uva.sc.ql.logic.Expression;
import uva.sc.ql.types.Type;

public class Addition extends BinaryExpression {

	public Addition(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}

	public Type getType() {
		return this.getType();
	}

	public String toString() {
		return "[op +]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
