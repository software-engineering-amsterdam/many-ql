package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class Substraction extends BinaryExpressions{

	public Substraction(Expression left, Expression right, CodeLines _codeLines) {
		super(left, right, Operator.SUB, _codeLines);
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitSubstraction(this);
	}
	
	@Override
	public NumberValue evaluate() {
		if (!NumberValue.isNumberValue(getLeftExpr()) || !NumberValue.isNumberValue(getRightExpr()))
			throw new IllegalArgumentException("Operands Not Of The Same Type. Substraction requires numbers.");
			
		return NumberValue.numberValueFromExpr(getLeftExpr()).substraction(NumberValue.numberValueFromExpr(getRightExpr()));
	}

	@Override
	public String evaluateType() {
		return Substraction.class.getName();
	}
	
	@Override
	public String toString(){
		return "Substraction(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
}
