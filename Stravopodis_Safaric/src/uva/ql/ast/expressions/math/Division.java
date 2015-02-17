package uva.ql.ast.expressions.math;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.*;

public class Division extends BinaryExpressions{

	public Division(Expression left, Expression right){
		super(left, right, Operators.DIV);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operators.DIV + this.getRightExpr();
	}

}
