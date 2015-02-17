package uva.ql.ast.expressions.logic;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operators;

public class Less_Eq extends BinaryExpressions{

	public Less_Eq(Expression _left, Expression _right, String _operator){
		super(_left, _right, Operators.LESS_EQ);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operators.LESS_EQ + this.getLeftExpr();
	}
}
