package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class Less_Eq extends BinaryExpressions{

	public Less_Eq(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.LESS_EQ, _codeLines);
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitLessEqual(this);
	}
	
	@Override
	public BooleanValue evaluate() {
		if (!NumberValue.isNumberValue(this.getLeftExpr()) || !NumberValue.isNumberValue(this.getRightExpr()))
			throw new IllegalArgumentException("Ilegal argument: <= operator requires both operands NumberValue");
		
		return NumberValue.numberValueFromExpr(this.getLeftExpr()).lessEqual(NumberValue.numberValueFromExpr(this.getRightExpr()));
	}

	@Override
	public String evaluateType() {
		return Less_Eq.class.getName();
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.LESS_EQ.getName() + this.getLeftExpr();
	}
}
