package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.VisitorInterface;

public class Multiplication extends BinaryExpressions{

	public Multiplication(Expression left, Expression right, CodeLines _codeLines){
		super(left, right, Operator.MUL, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Multiplication(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitMultiplication(this);
	}
	@Override
	public NumberValue evaluate() {
		return NumberValue.numberValueFromExpr(getLeftExpr()).multiplication(NumberValue.numberValueFromExpr(getRightExpr()));	
	}
}
