package qlProject.ast.expression;

public interface IExpression {

	public Object accept(IExpressionVisitor visitor);
	
	public String toString();
}
