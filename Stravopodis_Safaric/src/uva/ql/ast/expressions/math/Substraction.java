package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.VisitorInterface;

public class Substraction extends BinaryExpressions{

	public Substraction(Expression left, Expression right, CodeLines _codeLines) {
		super(left, right, Operator.SUB, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Substraction(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitSubstraction(this);
	}
	@Override
	public NumberValue evaluate() {
		return NumberValue.numberValueFromExpr(getLeftExpr()).substraction(NumberValue.numberValueFromExpr(getRightExpr()));
	}
}
