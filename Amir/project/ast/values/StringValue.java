package project.ast.values;

import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;

public class StringValue implements Value {

	public String str;

	public StringValue(String str){
	this.str = str;
	}
	
	@Override
	public String getValue() {
		return str;
	}

	@Override
	public boolean Equals(Value value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Value access(ExpressionEvaluationVisitor expressionEvaluationVisitor) {
		// TODO Auto-generated method stub
		return null;
	}
}
