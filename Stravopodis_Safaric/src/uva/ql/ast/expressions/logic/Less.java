package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.ExpressionVisitor;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.NumberValue;

public class Less extends BinaryExpressions{

	public Less(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.LESS, _codeLines);
	}
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.LESS.getName() + this.getLeftExpr();
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitLess(this);
	}
	@Override
	public BooleanValue evaluate() {
		if (!NumberValue.isNumberValue(this.getLeftExpr()) && !NumberValue.isNumberValue(this.getRightExpr()))
			throw new IllegalArgumentException("Ilegal argument: < operator requires both operands NumberValue");
		
		return new BooleanValue((int) this.getLeftExpr().evaluate().getValue() <
								(int) this.getRightExpr().evaluate().getValue());	
	}
}
