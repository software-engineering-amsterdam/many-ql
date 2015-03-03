package org.tax.datatypes;

public abstract class QLNumber<T extends Number> extends QLType implements Comparable<Number>{
	T value;

	public QLNumber(T value) {
		this.value = value;
	}
	
	public T getValue() { return value; }
	

	public abstract QLNumber<? extends Number> add(QLNumber<? extends Number> that);
	public abstract QLNumber<? extends Number> sub(QLNumber<? extends Number> that);
	public abstract QLNumber<? extends Number> mul(QLNumber<? extends Number> that);
	public abstract QLNumber<? extends Number> div(QLNumber<? extends Number> that);

	@Override
	public abstract int compareTo(Number o);

}
