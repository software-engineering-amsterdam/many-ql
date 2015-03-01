package project.ast.expression.unaryExpression;

import project.ast.expression.Expression;
import project.ast.value.TypeValue;
import project.ast.values.Value;

public interface UnaryExpression extends Expression {
	
	public TypeValue getType();
	public Value evaluate(Value value);
	
//	{
//		return new NumericalTypeValue();
//	};
}
