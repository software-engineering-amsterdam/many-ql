package uva.ql.ast.expressions.logic;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;

public class Greater_Eq extends BinaryExpressions{

	public Greater_Eq(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.GREATER_EQ, _codeLines);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.GREATER_EQ.getName() + this.getRightExpr();
	}
}
