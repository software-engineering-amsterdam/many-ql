package cons.ql.ast.expression;

import cons.ql.ast.ASTNode;

public abstract class Binary extends Expression {
	protected Expression left, right;
	protected String operator;
	
	public Binary(Expression left, Expression right, String operator) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	public String show() {
		return left.show() + " " + operator + " " + right.show();
	}
	
	public ASTNode getLeft() {
		return this.left;
	}
	
	public ASTNode getRight() {
		return this.right;
	}
}
