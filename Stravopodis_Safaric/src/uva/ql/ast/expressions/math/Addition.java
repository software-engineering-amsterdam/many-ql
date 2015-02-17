package uva.ql.ast.expressions.math;
import uva.ql.ast.expressions.*;
import uva.ql.supporting.Tuple;
public class Addition extends BinaryExpressions{

	public Addition(Expression left, Expression right, Tuple<Integer, Integer> _codeLines) {
		super(left, right, Operator.ADD, _codeLines);
	}
	
	@Override
	public String toString(){
		return "Addition(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
}
