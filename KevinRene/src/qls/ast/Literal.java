package qls.ast;

import ql.ast.expression.QLType;

public abstract class Literal<T> implements ASTNode{
	private final T value;
	
	public Literal(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public abstract QLType getType();
	
	public String toString() {
		return value.toString();
	}
}