package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;

public class Substraction extends BinaryExpressions{

	public Substraction(Expression left, Expression right, CodeLines _codeLines) {
		super(left, right, Operator.SUB, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Substraction(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
}
