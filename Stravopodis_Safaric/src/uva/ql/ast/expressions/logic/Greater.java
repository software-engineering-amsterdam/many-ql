package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class Greater extends BinaryExpressions{

	public Greater(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.GREATER, _codeLines);
	}

	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitGreater(this);
	}
	
	@Override
	public BooleanValue evaluate() {
		if (!NumberValue.isNumberValue(this.getLeftExpr()) || !NumberValue.isNumberValue(this.getRightExpr()))
			throw new IllegalArgumentException("Ilegal argument: > operator requires both operands NumberValue");
		
		return NumberValue.numberValueFromExpr(this.getLeftExpr()).greater(NumberValue.numberValueFromExpr(this.getRightExpr()));
	}

	@Override
	public String evaluateType() {
		return Greater.class.getName();
	}
	
	@Override 
	public String toString(){
		return this.getLeftExpr() + Operator.GREATER.getName() + this.getRightExpr();
	}
}
