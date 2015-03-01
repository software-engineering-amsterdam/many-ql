package project.ast.expression.StringExpr;


import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.expression.booleanExpr.BinaryOperation;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.values.BoolValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public class StringComparisonExpr extends BinaryStringExpr implements BinaryOperation{

	public StringComparisonExpr(StringExpression left, StringExpression right) {
		super(left, right);
	}

	public Value accept(ExpressionEvaluationVisitor visitor){
		return visitor.visit(this);//..visitAdditionExpr(toAdd);
	}

	@Override
	public void accept(VariablesCollectionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public HashSet<ErrorObject> accept(TypeCheckVisitor visitor){
		return visitor.visit(this);
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public Value getLeftHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value getRightHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value evaluate(Value left, Value right) {
		return new BoolValue(((String)left.getValue()).equals((String)right.getValue()));
	}
}
