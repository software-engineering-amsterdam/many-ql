package uva.ql.ast.expressions.math;
import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.value.NumberValue;

public class Addition extends BinaryExpressions{
	
	public Addition(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.ADD, _codeLines);
	}
	@Override
	public String toString(){
		return "Addition(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitAddition(this);
	}
	@Override
	public NumberValue evaluate() {
		NumberValue left = new NumberValue((Number)this.getLeftExpr().evaluate().getValue());
		NumberValue right = new NumberValue((Number)this.getRightExpr().evaluate().getValue());
		
		return new NumberValue(left.toDecimal() + right.toDecimal());
	}
}
