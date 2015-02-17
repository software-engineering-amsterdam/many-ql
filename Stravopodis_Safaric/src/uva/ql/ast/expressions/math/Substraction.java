package uva.ql.ast.expressions.math;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.*;

public class Substraction extends BinaryExpressions{

	public Substraction(Expression left, Expression right) {
		super(left, right, Operators.SUB);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operators.SUB + this.getRightExpr();
	}
}
