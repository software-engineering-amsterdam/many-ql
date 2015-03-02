package project.ast.expression;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import project.TypeCheckVisitor;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.expression.unaryExpression.Literal;
import project.ast.value.NullTypeValue;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public class Id implements Expression{

/* split this class to two*/

//	public BooleanExpression expr;
	public boolean bool;
	public String idString;
//	int numericalValue;
//	boolean booleanValue;
	public Literal literal;
	public Map<String,TypeValue> environment = new HashMap<String, TypeValue>();
	
	public Id (String idString){
		this.idString = idString;
	}
	
	public void setEnvironment(Map<String,TypeValue> environment){
		this.environment = environment;
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
//-- this should be resolved
//	@Override
//	public boolean accept(BooleanExpressionEvaluationVisitor visitor){//, Map<String, Id> varsMap) {
//		return visitor.visit(this);//, varsMap);
//	}
//	
//	@Override
//	public void accept(VariablesCollectionVisitor visitor){
//	visitor.visit(this);
//}

	//	public Id (String idString, int value){
//		this.idString = idString;
//		this.numericalValue = value;
//	}
	
//	public Id (String idString, boolean value){
//		this.idString = idString;
//		this.booleanValue = value;
//	}

	public String getIdString (){
		return this.idString;
	}

	@Override
	public TypeValue getType() {
//		assert (environment.containsKey(idString));//		System.out.println(this.environment.size());
		if (environment.containsKey(idString)){//		System.out.println(this.environment.size());
		return this.environment.get(idString);
		}
		else 
			return new NullTypeValue();
	}

	@Override
	public HashSet<ErrorObject> accept(TypeCheckVisitor visitor) {
		return visitor.visit(this);// TODO Auto-generated method stub
	}

	@Override
	public void accept(VariablesCollectionVisitor visitor) {
		visitor.visit(this);// TODO Auto-generated method stub
	}

	@Override
	public Value accept(ExpressionEvaluationVisitor visitor) {
		return visitor.visit(this);
	}

//	public void setNumericalValue(int value);//{
//		this.numericalValue = value;
//	}

//	public void setValue(Object value);//{
//		this.booleanValue = value;
//	}

//	public boolean getBooleanValue();//{
//		return this.booleanValue;
//	}
//	public Object getValue();//{
//		return this.numericalValue;
//	}
	
//	@Override
//	public int accept(BooleanExpressionEvaluationVisitor visitor){
//		return visitor.visit(this);//..visitAdditionExpr(toAdd);
//	}
	
//	@Override
//	public Map<String, Id> accept(VariablesCollectionVisitor visitor) {
//		return visitor.visit(this);//..visitAdditionExpr(toAdd);
//	}

//	@Override
//	public boolean accept(BooleanExpressionEvaluationVisitor visitor){
//		return visitor.visit(this);
//	}

//	@Override
//	public Map<String, Id> accept(VariablesCollectionVisitor2 visitor) {
//		return visitor.visit(this);//..visitAdditionExpr(toAdd);
//	}


}
