package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class NotEqual extends BinaryExpressions{

	public NotEqual(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.NOT_EQUAL, _codeLines);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitNotEqual(this);
	}
	
	@Override
	public BooleanValue evaluate() {
		if (!this.getLeftExpr().evaluate().getValue().getClass().equals(this.getRightExpr().evaluate().getValue().getClass()))
			throw new IllegalArgumentException("IllegalArgumentException: Both operands of != must be of same time");
		
		return new BooleanValue(this.getLeftExpr().evaluate().getValue() != this.getRightExpr().evaluate().getValue());
	}
	
	@Override
	public String evaluateType() {
		return NotEqual.class.getName();
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.NOT_EQUAL.getName() + this.getRightExpr();
	}
}
