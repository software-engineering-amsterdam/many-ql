package uva.ql.ast.value;

public abstract class GenericValue<T> {
	public abstract T getValue();
	public abstract float floatValue();
	public abstract int intValue();
	
}
