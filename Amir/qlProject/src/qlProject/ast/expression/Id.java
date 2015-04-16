package qlProject.ast.expression;

public class Id implements IExpression{

	private final String idString;
	
	public Id (String idString){
		this.idString = idString;
	}
	
	public String getIdString (){
		return this.idString;
	}

	@Override
	public Object accept(IExpressionVisitor visitor) {
		return visitor.visit(this);
	}
}
