package ql.ast.expression;

public abstract class Binary extends Expression {
	
	protected final Expression left;
	protected final Expression right;
	
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