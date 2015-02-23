package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.VisitorInterface;

public class Greater extends BinaryExpressions{

	public Greater(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.GREATER, _codeLines);
	}

	@Override 
	public String toString(){
		return this.getLeftExpr() + Operator.GREATER.getName() + this.getRightExpr();
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitGreater(this);
	}
	@Override
	public BooleanValue evaluate() {
		if (!NumberValue.isNumberValue(this.getLeftExpr()) && !NumberValue.isNumberValue(this.getRightExpr()))
			throw new IllegalArgumentException("Ilegal argument: > operator requires both operands NumberValue");
		
		return new BooleanValue((int) this.getLeftExpr().evaluate().getValue() >
								(int) this.getRightExpr().evaluate().getValue());	
	}
}
