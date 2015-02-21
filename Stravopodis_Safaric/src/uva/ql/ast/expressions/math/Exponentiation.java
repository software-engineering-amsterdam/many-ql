package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;

public class Exponentiation extends BinaryExpressions{

	public Exponentiation(Expression left, Expression right, CodeLines _codeLines) {
		super(left, right, Operator.EXP, _codeLines);
	}
	
	@Override 
	public String toString(){
		return "Exponentiation(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
	
}
