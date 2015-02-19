package uva.ql.ast.expressions.math;

import uva.ql.ast.expressions.*;
import uva.ql.supporting.Tuple;

public class Division extends BinaryExpressions{

	public Division(Expression left, Expression right, Tuple<Integer, Integer> _codeLines){
		super(left, right, Operator.DIV, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Division(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}

}
