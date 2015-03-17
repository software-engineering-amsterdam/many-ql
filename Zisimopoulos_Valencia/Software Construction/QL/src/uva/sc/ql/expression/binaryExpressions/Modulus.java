package uva.sc.ql.expression.binaryExpressions;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

public class Modulus extends BinaryExpression {

    public Modulus(Expression firstOperand, Expression secondOperand) {
	super(firstOperand, secondOperand);
    }

    public String toString() {
	return "[op %]";
    }

    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }
}
