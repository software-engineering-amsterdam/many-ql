package uva.sc.ql.expression.unaryExpressions;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

@SuppressWarnings({ "rawtypes" })
public class Minus extends UnaryExpression {

    public Minus(Expression operand) {
	super(operand);
    }

    public String toString() {
	return "[un -]";
    }

    @Override
    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }

}
