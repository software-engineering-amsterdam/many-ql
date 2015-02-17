package uva.ql.ast.expressions.logic;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operators;

public class Or extends BinaryExpressions{

	public Or(Expression _left, Expression _right, String _operator) {
		super(_left, _right, Operators.OR);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operators.OR + this.getRightExpr();
	}
}
