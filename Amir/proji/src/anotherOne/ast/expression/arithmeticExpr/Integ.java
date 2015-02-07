package anotherOne.ast.expression.arithmeticExpr;

import java.util.List;
import java.util.Map;

import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.VariablesCollectionVisitor;
import anotherOne.ast.expression.booleanExpr.BooleanExpressionEvaluationVisitor;

public class Integ implements ArithmeticExpression {
	
	public int value;
	
	public Integ (int value){
		this.value = value;
	}
	public int getValue (){
		return value;
	}
	@Override
	public int accept(BooleanExpressionEvaluationVisitor visitor){
		return visitor.visit(this);//..visitAdditionExpr(toAdd);
	}
	
	@Override
	public void accept(VariablesCollectionVisitor visitor) {
		visitor.visit(this);//..visitAdditionExpr(toAdd);
	}
}
