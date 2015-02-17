package uva.ql.ast.expressions.logic;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operators;

public class NotEqual extends BinaryExpressions{

	public NotEqual(Expression _left, Expression _right, String _operator) {
		super(_left, _right, Operators.NOT_EQUAL);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString(){
		return this.getLeftExpr() + Operators.NOT_EQUAL + this.getRightExpr();
	}
}
