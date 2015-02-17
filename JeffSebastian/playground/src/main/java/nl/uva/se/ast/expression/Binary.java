package nl.uva.se.ast.expression;

public abstract class Binary implements Expression {

	private final Expression left;
	private final Expression right;
	
	public Binary(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}
	
}
