package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class Multiplication extends BinaryExpressions{

	public Multiplication(Expression left, Expression right, CodeLines _codeLines){
		super(left, right, Operator.MUL, _codeLines);
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitMultiplication(this);
	}
	
	@Override
	public NumberValue evaluate() {
		if (!NumberValue.isNumberValue(getLeftExpr()) || !NumberValue.isNumberValue(getRightExpr()))
			throw new IllegalArgumentException("Operands Not Of The Same Type. Multiplication requires numbers.");
			
		return NumberValue.numberValueFromExpr(getLeftExpr()).multiplication(NumberValue.numberValueFromExpr(getRightExpr()));	
	}

	@Override
	public String evaluateType() {
		return Multiplication.class.getName();
	}
	
	@Override
	public String toString(){
		return "Multiplication(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
}
