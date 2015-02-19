package uva.ql.ast.expressions.logic;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.supporting.Tuple;

public class Or extends BinaryExpressions{

	public Or(Expression _left, Expression _right, Tuple<Integer, Integer> _codeLines) {
		super(_left, _right, Operator.OR, _codeLines);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.OR.getName() + this.getRightExpr();
	}
}
