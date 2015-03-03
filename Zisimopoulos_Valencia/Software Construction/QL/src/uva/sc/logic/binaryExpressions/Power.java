package uva.sc.logic.binaryExpressions;

import uva.sc.ast.INodeVisitor;
import uva.sc.logic.Expression;

public class Power extends BinaryExpression{

	public Power(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op ^]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression evaluate() {
		return null;
	}
}
