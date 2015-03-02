package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class Or extends BinaryExpressions{

	public Or(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.OR, _codeLines);
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitOr(this);
	}
	
	@Override
	public GenericValue<?> evaluate() {
		if (!BooleanValue.isBooleanValue(this.getLeftExpr()) || !BooleanValue.isBooleanValue(this.getRightExpr()))
			throw new IllegalArgumentException("Ilegal argument: || operator requires both operands BooleanValue");
		
		return BooleanValue.booleanValueFromExpr(this.getLeftExpr()).or(BooleanValue.booleanValueFromExpr(this.getRightExpr()));
	}

	@Override
	public String evaluateType() {
		return Or.class.getName();
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.OR.getName() + this.getRightExpr();
	}
}
