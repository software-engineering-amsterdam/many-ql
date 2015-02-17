package uva.ql.ast.expressions.logic;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operators;

public class And extends BinaryExpressions{

	public And(Expression _left, Expression _right, String _operator){
		super(_left, _right, Operators.AND);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operators.AND + this.getRightExpr();
	}
}
