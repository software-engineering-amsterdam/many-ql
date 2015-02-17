package uva.ql.ast.expressions;
import uva.ql.supporting.*;

public class BinaryExpressions extends Expression{

	private Expression left;
	private Expression right;
	private Operator operator;
	
	public BinaryExpressions(Expression _left, Expression _right, Operator _operator, 
			Tuple<Integer, Integer> codeLines) {
		super(codeLines);
		this.left = _left;
		this.right = _right;
		this.operator = _operator;
	}
	
	public Expression getLeftExpr(){
		return this.left;
	}
	
	public Expression getRightExpr(){
		return this.right;
	}
	
	public Operator getOperator(){
		return this.operator;
	}
	
	@Override
	public String toString(){
		return this.getClass().toString();
	}
}
