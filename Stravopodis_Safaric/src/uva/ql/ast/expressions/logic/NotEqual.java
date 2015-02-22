package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;

public class NotEqual extends BinaryExpressions{

	public NotEqual(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.NOT_EQUAL, _codeLines);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.NOT_EQUAL.getName() + this.getRightExpr();
	}
}
