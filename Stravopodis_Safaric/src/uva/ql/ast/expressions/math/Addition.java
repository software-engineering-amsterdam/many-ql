package uva.ql.ast.expressions.math;
import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.VisitorInterface;

public class Addition extends BinaryExpressions{
	
	public Addition(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.ADD, _codeLines);
	}
	@Override
	public String toString(){
		return "Addition(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitAddition(this);
	}
	@Override
	public NumberValue evaluate() {
		if (!NumberValue.isNumberValue(getLeftExpr()) || !NumberValue.isNumberValue(getRightExpr()))
			throw new IllegalArgumentException("Hello World");
		
		return NumberValue.numberValueFromExpr(getLeftExpr()).addition(NumberValue.numberValueFromExpr(getRightExpr()));
	}
}
