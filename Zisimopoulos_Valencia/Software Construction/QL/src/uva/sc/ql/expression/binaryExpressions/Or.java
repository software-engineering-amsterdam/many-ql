package uva.sc.ql.expression.binaryExpressions;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

@SuppressWarnings({ "rawtypes" })
public class Or extends BinaryExpression {

    public Or(Expression firstOperand, Expression secondOperand) {
	super(firstOperand, secondOperand);
    }

    public String toString() {
	return "[op ||]";
    }

    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }
}
