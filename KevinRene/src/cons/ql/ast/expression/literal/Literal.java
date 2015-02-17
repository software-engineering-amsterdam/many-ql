package cons.ql.ast.expression.literal;

import cons.ql.ast.Expression;

public abstract class Literal<T> extends Expression {
	
	private final T value;
	
	public Literal(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public String toString() {
		return value.toString();
	}
}
