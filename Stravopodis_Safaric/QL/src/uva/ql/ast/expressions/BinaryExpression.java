package uva.ql.ast.expressions;
import uva.ql.ast.CodeLines;

public abstract class BinaryExpression extends Expression{

	private Expression left;
	private Expression right;
	private Operator operator;
	
	public BinaryExpression(Expression _left, Expression _right, Operator _operator, CodeLines _codeLines) {
		super(_codeLines);
		
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
	
	public Object getLeftExpressionValue(){
		return this.left.getValue();
	}
	
	public Object getRightExpressionValue(){
		return this.right.getValue();
	}
	
	public Operator getOperator(){
		return this.operator;
	}
}
