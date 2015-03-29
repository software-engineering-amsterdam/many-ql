package ql.ast.expression;

import java.util.Arrays;

import ql.Value;
import ql.ast.Expression;

public abstract class Literal<T extends Value> extends Expression {
	
	private final T value;
	
	public Literal(T value) {
		super(Arrays.asList());
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}	
	
	public String toString() {
		return value.toString();
	}
}