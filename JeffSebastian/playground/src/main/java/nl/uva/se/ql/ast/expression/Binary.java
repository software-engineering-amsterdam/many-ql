package nl.uva.se.ql.ast.expression;

public abstract class Binary extends Expression {

	private final Expression left;
	private final Expression right;

	public Binary(int lineNumber, int offset, Expression left, Expression right) {
		super(lineNumber, offset);
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
