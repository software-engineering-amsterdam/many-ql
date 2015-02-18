package uva.ql.ast.expressions.math;

import uva.ql.ast.expressions.*;
import uva.ql.supporting.Tuple;

public class Multiplication extends BinaryExpressions{

	public Multiplication(Expression left, Expression right, Tuple<Integer, Integer> _codeLines){
		super(left, right, Operator.MUL, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Multiplication(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
}
