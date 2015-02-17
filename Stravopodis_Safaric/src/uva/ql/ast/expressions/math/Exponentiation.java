package uva.ql.ast.expressions.math;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.*;

public class Exponentiation extends BinaryExpressions{

	public Exponentiation(Expression left, Expression right) {
		super(left, right, Operators.EXP);
	}
	
	@Override 
	public String toString(){
		return this.getLeftExpr() + Operators.EXP + this.getRightExpr(); 
	}
	
}
