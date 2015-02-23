package org.uva.sea.ql.AST.value;

public abstract class AbstractValue<T> {
	public abstract T getValue();
	
	public AbstractValue<T> add(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> minus(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> divide(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> multiply(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> or(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> and(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> greaterThan(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> lessThan(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> greaterEqual(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> lessEqual(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
	public AbstractValue<T> not() { throw new UnsupportedOperationException(); }
	public AbstractValue<T> equal(AbstractValue<T> value) { throw new UnsupportedOperationException(); }
}