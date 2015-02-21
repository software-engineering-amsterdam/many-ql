package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;

public class Equal extends BinaryExpressions{

	public Equal(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.EQUAL, _codeLines);
	}
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.EQUAL.getName() + this.getRightExpr();
	}
}
