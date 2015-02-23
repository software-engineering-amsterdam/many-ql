package cons.ql.ast.expression;

import java.util.Arrays;

import cons.ql.ast.Expression;

@SuppressWarnings("rawtypes")
public abstract class Literal<T> extends Expression {
	private final T value;
	
	public Literal(T value) {
		super(Arrays.asList());
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}	
	
	public Literal add(Literal argument) {
		return this;
	}
	
	public Literal addInteger(int argument) {
		return this;
	}
	
	public Literal addFloat(float argument) {
		return this;
	}
	
	public Literal addString(String argument) {
		return this;
	}
	
	public String toString() {
		return value.toString();
	}
}
