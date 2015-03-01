package project.ast.expression.arithmeticExpr;

import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.expression.unaryExpression.Literal;
import project.ast.value.NumericalTypeValue;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public class Integ extends Literal implements ArithmeticExpression {
	
	public int value;
	
	public Integ (int value){
		this.value = value;
	}
	public int getValue (){
		return value;
	}
	@Override
	public Value accept(ExpressionEvaluationVisitor visitor){
		return visitor.visit(this);//..visitAdditionExpr(toAdd);
	}
	
	@Override
	public void accept(VariablesCollectionVisitor visitor) {
		visitor.visit(this);//..visitAdditionExpr(toAdd);
	}
	@Override
	public TypeValue getType() {
		return new NumericalTypeValue();// TODO Auto-generated method stub
//		return null;
	}
	@Override
	public HashSet<ErrorObject> accept(TypeCheckVisitor visitor) {
		return visitor.visit(this);// TODO Auto-generated method stub
	}
//	@Override
//	public void accept(ForbidReferencesVisitor visitor) {
//		// TODO Auto-generated method stub
//		
//	}
}
