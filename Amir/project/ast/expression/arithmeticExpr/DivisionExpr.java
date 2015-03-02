package project.ast.expression.arithmeticExpr;

import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.expression.Expression;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.expression.booleanExpr.BinaryOperation;
import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;
import project.ast.values.IntValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public class DivisionExpr extends BinaryArithmeticExpr implements BinaryOperation{

	public DivisionExpr(Expression left, Expression right) {
		super(left, right);
	}
	
	public Value accept(ExpressionEvaluationVisitor visitor){
		return visitor.visit(this);//..visitAdditionExpr(toAdd);
	}

	public IntValue evaluate(Value left, Value right){
		return new IntValue((int)left.getValue() + (int)right.getValue());
	}
	
	@Override
	public void accept(VariablesCollectionVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public HashSet<ErrorObject> accept(TypeCheckVisitor visitor){
		return visitor.visit(this);
	}

//	@Override
//	public boolean accept(TypeCheckVisitor visitor) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public Expression getLeft() {
		return this.left;
	}

	@Override
	public Expression getRight() {
		return this.right;
	}

//	@Override
//	public void accept(ForbidReferencesVisitor visitor) {
//		visitor.visit(this);
//	}

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
