package project.ast.expression;

import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.expression.booleanExpr.BooleanExpression;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.expression.unaryExpression.Literal;
import project.ast.value.BooleanTypeValue;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public class Bool extends Literal implements BooleanExpression { // refine interface implementation //implements ArithmeticExpression {
	
	public boolean value;
	public boolean isType = false;
	
	public Bool (boolean value){
		this.value = value;
	}
	public boolean getBoolValue (){
		return this.value;
	}
	@Override
	public TypeValue getType() {
		return new BooleanTypeValue();
	}

	@Override
	public Value accept(ExpressionEvaluationVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public void accept(VariablesCollectionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public HashSet<ErrorObject> accept(TypeCheckVisitor visitor) {
		return visitor.visit(this);
	}

//	public boolean isType(TypeValue type){
//		return (type == BooleanTypeValue);
//	}
	
//	@Override
//	public int accept(ArithmeticExpressionEvaluationVisitor visitor, Map<String, Id> varsMap){
//		return visitor.visit(this, varsMap);//..visitAdditionExpr(toAdd);
//	}
	
//	@Override
//	public Map<String, Id> accept(VariablesCollectionVisitor visitor) {
//		return visitor.visit(this);//..visitAdditionExpr(toAdd);
//	}
}
