package project.ast.expression.booleanExpr;

import project.ast.values.Value;

public interface BinaryOperation extends Value {

	public Value getLeftHand();
	public Value getRightHand();
	public Value evaluate(Value left, Value right);
	
}
