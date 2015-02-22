package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;

public class Division extends BinaryExpressions{

	public Division(Expression left, Expression right, CodeLines _codeLines){
		super(left, right, Operator.DIV, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Division(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitDivision(this);
	}
	@Override
	public NumberValue evaluate() {
		NumberValue left = new NumberValue((Number)this.getLeftExpr().evaluate().getValue());
		NumberValue right = new NumberValue((Number)this.getRightExpr().evaluate().getValue());
		
		if (left.toInt() == 0)
			throw new IllegalArgumentException("Argument divisor 0");
		
		return new NumberValue(	left.toDecimal() / right.toDecimal());
	}
}
