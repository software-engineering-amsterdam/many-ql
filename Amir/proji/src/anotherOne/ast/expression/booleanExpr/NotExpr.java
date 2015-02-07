package anotherOne.ast.expression.booleanExpr;

import anotherOne.ast.expression.VariablesCollectionVisitor;

public class NotExpr implements BooleanExpression //implements BooleanExpression
{
	public BooleanExpression expr;
	
	public NotExpr(BooleanExpression expr) {
		this.expr = expr;
	}

	@Override
	public boolean accept(BooleanExpressionEvaluationVisitor visitor){//, Map<String, Id> varsMap) {
		return visitor.visit(this);//, varsMap);
	}

	public void accept(VariablesCollectionVisitor visitor){
	visitor.visit(this);
}

}
