package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;

public class Multiplication extends BinaryExpressions{

	public Multiplication(Expression left, Expression right, CodeLines _codeLines){
		super(left, right, Operator.MUL, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Multiplication(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitMultiplication(this);
	}
	@Override
	public NumberValue evaluate() {
		NumberValue left = new NumberValue((Number)this.getLeftExpr().evaluate().getValue());
		NumberValue right = new NumberValue((Number)this.getRightExpr().evaluate().getValue());
		
		return new NumberValue(left.toDecimal() * right.toDecimal());	
	}
}
