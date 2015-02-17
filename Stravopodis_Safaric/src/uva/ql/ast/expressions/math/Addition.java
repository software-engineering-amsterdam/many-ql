package uva.ql.ast.expressions.math;
import uva.ql.ast.expressions.*;
public class Addition extends BinaryExpressions{

	public Addition(Expression left, Expression right) {
		super(left, right, Operators.ADD);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operators.ADD + this.getRightExpr();
	}
}
