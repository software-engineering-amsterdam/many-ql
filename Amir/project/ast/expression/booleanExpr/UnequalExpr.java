package project.ast.expression.booleanExpr;

import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.expression.Expression;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.value.BooleanTypeValue;
import project.ast.value.TypeValue;
import project.ast.values.BoolValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public class UnequalExpr extends BinaryBooleanExpr implements BinaryOperation{

//	public ArithmeticExpression left;
//	public ArithmeticExpression right;
	
	public UnequalExpr(Expression left, Expression right){
		super(left,right);
	}

	@Override
	public Value accept(ExpressionEvaluationVisitor visitor){//, Map<String, Id> varsMap) {
		return visitor.visit(this);//, varsMap);
	}

	public void accept(VariablesCollectionVisitor visitor){
	visitor.visit(this);
	}

	@Override
	public Value evaluate(Value left, Value right) {
		return new BoolValue(left.getValue() != left.getValue());
	}

	@Override
	public Expression getLeft() {
		return this.left;
	}

	@Override
	public Expression getRight() {
		return this.right;
	}

	@Override
	public TypeValue getType() {
		return new BooleanTypeValue();
	}

	@Override
	public HashSet<ErrorObject> accept(TypeCheckVisitor visitor) {
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

}
