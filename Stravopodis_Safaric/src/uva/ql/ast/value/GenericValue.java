package uva.ql.ast.value;

public abstract class GenericValue<T> {
	public abstract T getValue();
	public abstract int toInt();
	public abstract float toDecimal();
}
