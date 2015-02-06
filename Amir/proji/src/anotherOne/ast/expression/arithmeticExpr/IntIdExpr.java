package anotherOne.ast.expression.arithmeticExpr;

import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.VariablesCollectionVisitor;
import anotherOne.ast.expression.booleanExpr.BooleanExpressionEvaluationVisitor;

public class IntIdExpr extends Id implements ArithmeticExpression {

//	public BooleanExpression expr;

	public int integer;
//	public String idString;
	// comment: set/get value should/could happen through typeValue
	public IntIdExpr(String idString) {
//		this.expr = expr;
		super(idString);
//		this.idString = idString;
	}
	
//	public IntIdExpr(String idString, int integer) {
////		this.expr = expr;
//		this.idString = idString;
//		this.integer = integer;
//	}

	public void setValue(int integer){
		this.integer = integer;
	}
	
	public int getValue(){
		return this.integer;
	}
	
//	@Override
//	public String getIdString (){
//		return this.idString;
//	}

	@Override
	public int accept(BooleanExpressionEvaluationVisitor visitor){//, Map<String, Id> varsMap) {
		return visitor.visit(this);//, varsMap);
	}

	@Override
	public void accept(VariablesCollectionVisitor visitor){
	visitor.visit(this);
}

	
}
