package anotherOne.ast.expression;

import java.util.List;
import java.util.Map;

import anotherOne.ast.IGlobalElement;

public class Bool implements IGlobalElement { // refine interface implementation //implements ArithmeticExpression {
	
	public boolean value;
	
	public Bool (boolean value){
		this.value = value;
	}
	public boolean getBoolValue (){
		return this.value;
	}
//	@Override
//	public int accept(ArithmeticExpressionEvaluationVisitor visitor, Map<String, Id> varsMap){
//		return visitor.visit(this, varsMap);//..visitAdditionExpr(toAdd);
//	}
	
//	@Override
//	public Map<String, Id> accept(VariablesCollectionVisitor visitor) {
//		return visitor.visit(this);//..visitAdditionExpr(toAdd);
//	}
}
