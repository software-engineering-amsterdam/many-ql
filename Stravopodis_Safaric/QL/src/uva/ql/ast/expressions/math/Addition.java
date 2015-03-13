package uva.ql.ast.expressions.math;
import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class Addition extends BinaryExpressions{
	
	public Addition(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.ADD, _codeLines);
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitAddition(this);
	}
	
	@Override
	public NumberValue evaluate() {
		if (!NumberValue.isNumberValue(getLeftExpr()) || !NumberValue.isNumberValue(getRightExpr())){
			throw new IllegalArgumentException("Operands Not Of The Same Type. Addition requires numbers.");
		}
		return NumberValue.numberValueFromExpr(getLeftExpr()).addition(NumberValue.numberValueFromExpr(getRightExpr()));
	}
	
	@Override
	public String evaluateType() {
		return Addition.class.getName();
	}
	
	@Override
	public String toString(){
		return "Addition(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}

}
