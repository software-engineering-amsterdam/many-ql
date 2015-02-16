package anotherOne.ast.expression.booleanExpr;

import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.VariablesCollectionVisitor;

public class BoolIdExpr extends Id implements BooleanExpression {

//	public BooleanExpression expr;

	public boolean bool;
//	public String idString;
	
	public BoolIdExpr(String idString) {
//		this.expr = expr;
//		this.idString = idString;
		super(idString);
	}

	public void setValue(boolean bool){
		this.bool = bool;
	}

	public boolean getValue(){
		return this.bool;
	}
	
//	public String getIdString (){
//		return this.idString;
//	}

	@Override
	public boolean accept(BooleanExpressionEvaluationVisitor visitor){//, Map<String, Id> varsMap) {
		return visitor.visit(this);//, varsMap);
	}
	
	@Override
	public void accept(VariablesCollectionVisitor visitor){
	visitor.visit(this);
}
}
