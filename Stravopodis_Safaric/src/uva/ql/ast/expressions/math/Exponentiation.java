package uva.ql.ast.expressions.math;

import uva.ql.ast.expressions.*;
import uva.ql.supporting.Tuple;

public class Exponentiation extends BinaryExpressions{

	public Exponentiation(Expression left, Expression right, Tuple<Integer, Integer> _codeLines) {
		super(left, right, Operator.EXP, _codeLines);
	}
	
	@Override 
	public String toString(){
		return "Exponentiation(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	
}
