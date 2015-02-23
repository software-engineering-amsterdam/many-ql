package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.VisitorInterface;

public class Division extends BinaryExpressions{

	public Division(Expression left, Expression right, CodeLines _codeLines){
		super(left, right, Operator.DIV, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Division(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitDivision(this);
	}
	@Override
	public NumberValue evaluate() {
		NumberValue left = NumberValue.numberValueFromExpr(this.getLeftExpr());
		
		if (left.intValue() == 0)
			throw new IllegalArgumentException("Argument divisor 0");
		
		return left.division(NumberValue.numberValueFromExpr(getRightExpr()));
	}
}
