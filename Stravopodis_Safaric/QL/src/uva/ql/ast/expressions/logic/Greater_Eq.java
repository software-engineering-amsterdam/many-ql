package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class Greater_Eq extends BinaryExpressions{

	public Greater_Eq(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.GREATER_EQ, _codeLines);
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitGreaterEqual(this);
	}
	
	@Override
	public BooleanValue evaluate() {
		if (!NumberValue.isNumberValue(this.getLeftExpr()) || !NumberValue.isNumberValue(this.getRightExpr()))
			throw new IllegalArgumentException("Ilegal argument: >= operator requires both operands NumberValue");
		
		return NumberValue.numberValueFromExpr(this.getLeftExpr()).greaterEqual(NumberValue.numberValueFromExpr(this.getRightExpr()));
	}

	@Override
	public String evaluateType() {
		return Greater_Eq.class.getName();
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.GREATER_EQ.getName() + this.getRightExpr();
	}
}
