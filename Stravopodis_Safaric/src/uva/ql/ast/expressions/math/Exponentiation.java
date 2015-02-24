package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.VisitorInterface;

public class Exponentiation extends BinaryExpressions{

	public Exponentiation(Expression left, Expression right, CodeLines _codeLines) {
		super(left, right, Operator.EXP, _codeLines);
	}
	
	@Override 
	public String toString(){
		return "Exponentiation(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitExponentiation(this);
	}
	@Override
	public NumberValue evaluate() {
		return NumberValue.numberValueFromExpr(getLeftExpr()).exponentiation(NumberValue.numberValueFromExpr(getRightExpr()));
	}
}
