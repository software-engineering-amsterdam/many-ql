package uva.ql.ast.expressions.math;
import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;

public class Addition extends BinaryExpressions{

	public Addition(Expression left, Expression right, CodeLines _codeLines) {
		super(left, right, Operator.ADD, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Addition(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
}
