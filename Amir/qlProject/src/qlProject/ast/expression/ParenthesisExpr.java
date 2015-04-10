package qlProject.ast.expression;

public class ParenthesisExpr implements IExpression {

	private final IExpression subExpression;

	public ParenthesisExpr(IExpression subExpression){
		this.subExpression = subExpression;
	}

	@Override
	public Object accept(IExpressionVisitor visitor) {
		return visitor.visit(this);
	}

	public IExpression getSubExpression(){
		return subExpression;
	}
}