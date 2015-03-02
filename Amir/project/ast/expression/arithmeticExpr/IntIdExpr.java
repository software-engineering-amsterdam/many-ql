package project.ast.expression.arithmeticExpr;

import project.ast.expression.Id;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.values.Value;

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
	
//	public Object getValue(){
//		return this.integer;
//	}
	
//	@Override
//	public String getIdString (){
//		return this.idString;
//	}

	@Override
	public Value accept(ExpressionEvaluationVisitor visitor){//, Map<String, Id> varsMap) {
		return visitor.visit(this);//, varsMap);
	}

	@Override
	public void accept(VariablesCollectionVisitor visitor){
	visitor.visit(this);
}

	
}
