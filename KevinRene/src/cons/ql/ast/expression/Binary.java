package cons.ql.ast.expression;

import cons.ql.ast.ASTNode;
import cons.ql.ast.Expression;
import cons.ql.ast.Visitor;

public abstract class Binary extends Expression {
	protected Expression left, right;
	protected String operator;
	
	public Binary(Expression left, Expression right, String operator) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}
	
	public ASTNode getLeft() {
		return this.left;
	}
	
	public ASTNode getRight() {
		return this.right;
	}
	
	@Override
	public String toString() {
		return left.toString() + " " + operator + " " + right.toString();
	}
	
	@Override
	public abstract void accept(Visitor visitor);
}
