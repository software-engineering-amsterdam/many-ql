package uva.ql.ast.expressions.literals;
import uva.ql.ast.expressions.Expression;

public abstract class Value<T> extends Expression{
	
	public abstract T getValue();
	public abstract String toString();
}

