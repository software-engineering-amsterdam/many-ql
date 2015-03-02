package project.ast.expression;

import project.ast.value.TypeValue;
import project.ast.values.Value;

public interface BinaryExpression extends Expression {
	
	public Expression getLeft();
	public Expression getRight();
	public TypeValue getType();
	public Value evaluate(Value left, Value right);
	
//	{
//		return new NumericalTypeValue();
//	};
}
