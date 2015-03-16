package ast.expression;

public abstract class Binary extends Expression {
	private final Expression leftExpression, rightExpression;
	
	public Binary (Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
			
	public Expression getLeftExpression() {
		return leftExpression;
	}
			
	public Expression getRightExpression() {
		return rightExpression;
	}
}
