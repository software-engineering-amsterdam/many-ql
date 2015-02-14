package ast.expression;


public abstract class ArithmeticExpression extends Expression {
	private Expression leftExp, rightExp;
	
	public ArithmeticExpression (Expression leftExp, Expression rightExp) {
		this.leftExp = leftExp;
		this.rightExp = rightExp;
	}
	
	public Expression getLeftExp() {
		return leftExp;
	}
	
	public Expression getRightExp() {
		return rightExp;
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
