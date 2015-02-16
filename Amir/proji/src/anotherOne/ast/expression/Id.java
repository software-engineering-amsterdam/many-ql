package anotherOne.ast.expression;

public class Id implements Expression{

/* split this class to two*/
	
	String idString;
//	int numericalValue;
//	boolean booleanValue;
	
	public Id (String idString){
		this.idString = idString;
	}
	
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
