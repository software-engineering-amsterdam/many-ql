package uva.ql.ast.expressions.math;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;

public class Division extends BinaryExpressions{

	public Division(Expression left, Expression right, CodeLines _codeLines){
		super(left, right, Operator.DIV, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Division(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}

}
