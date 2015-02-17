package uva.ql.ast.expressions.math;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.*;

public class Multiplication extends BinaryExpressions{

	public Multiplication(Expression left, Expression right){
		super(left, right, Operators.MUL);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operators.MUL + this.getRightExpr();
	}
}
