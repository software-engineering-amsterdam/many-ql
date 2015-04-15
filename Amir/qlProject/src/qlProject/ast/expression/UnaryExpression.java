package qlProject.ast.expression;

public abstract class UnaryExpression implements IExpression {
	
	private final IExpression subExpression;
	
	public UnaryExpression(IExpression subExpression){
		
		this.subExpression = subExpression;
	}


	public IExpression getSubExpression(){
		return subExpression;
	}
	
}