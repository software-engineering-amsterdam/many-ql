package uva.sc.ql.expression.binaryExpressions;

import uva.sc.core.types.Type;
import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

@SuppressWarnings({ "rawtypes" })
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

    @Override
    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }

}
