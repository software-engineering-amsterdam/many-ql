package uva.ql.ast.expressions;

import uva.ql.supporting.Tuple;

public class BinaryExpressions extends Expression{

	private Expression left;
	private Expression right;
	private String operator;
	
	public BinaryExpressions(Expression _left, Expression _right, String _operator){
		this.left = isValidExpression(_left);
		this.right = isValidExpression(_right);
		this.operator = _operator;
	}
	
	public Expression getLeftExpr(){
		return this.left;
	}
	
	public Expression getRightExpr(){
		return this.right;
	}
	
	public String getOperator(){
		return this.operator;
	}
	
	private Expression isValidExpression(Expression e){
		if (e != null){
			return e;
		}
		return null;
	}

	@Override
	public Tuple<Integer, Integer> getCodeLine() {
		return null;
	}
	
}
