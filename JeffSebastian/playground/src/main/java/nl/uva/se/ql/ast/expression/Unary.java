package nl.uva.se.ql.ast.expression;

public abstract class Unary extends Expression{

	private final Expression singleExpression;
	
	public Unary(int lineNumber, int offset, Expression singleExpression) {
		super(lineNumber, offset);
		this.singleExpression = singleExpression;	
	}
	
	public Expression getSingleExpression()
	{
		return this.singleExpression;
	}
}
