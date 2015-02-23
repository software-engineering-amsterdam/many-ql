package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.VisitorInterface;

public class And extends BinaryExpressions{

	public And(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.AND, _codeLines);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.AND.getName() + this.getRightExpr();
	}
	@Override
	public BooleanValue evaluate() {
		if (!BooleanValue.isBooleanValue(this.getLeftExpr()) || !BooleanValue.isBooleanValue(this.getRightExpr()))
			throw new IllegalArgumentException("Ilegal argument: && operator requires both operands BooleanValue");
		
		return new BooleanValue(	(boolean)this.getLeftExpr().evaluate().getValue() && 
									(boolean)this.getRightExpr().evaluate().getValue());
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitAnd(this);
	}
}
