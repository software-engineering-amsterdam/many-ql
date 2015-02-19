package uva.ql.ast.expressions.math;

import uva.ql.ast.expressions.*;
import uva.ql.supporting.Tuple;

public class Substraction extends BinaryExpressions{

	public Substraction(Expression left, Expression right, Tuple<Integer, Integer> _codeLines) {
		super(left, right, Operator.SUB, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Substraction(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
}
