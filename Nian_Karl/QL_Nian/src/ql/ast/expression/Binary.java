package ql.ast.expression;

public abstract class Binary extends Expression {
	
	private final Expression left;
	private final Expression right;
	
	public Binary(Expression left, Expression right){
		this.left = left;
		this.right = right;
	}
	
	public Expression getLeft(){
		return this.left;
	}
	
	public Expression getRight(){
		return this.right;
	}
	
}
