package uva.ql.ast.expressions.logic;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operators;

public class Greater extends BinaryExpressions{

	public Greater(Expression _left, Expression _right, String _operator){
		super(_left, _right, Operators.GREATER);
	}

	@Override 
	public String toString(){
		return this.getLeftExpr() + Operators.GREATER + this.getRightExpr();
	}
}
