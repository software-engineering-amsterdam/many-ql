package uva.ql.ast.value;

import uva.ql.ast.type.*;

public abstract class GenericValue<T> {

	public abstract T getValue();
	public abstract Type getValueType();
	public abstract boolean equalsTo(GenericValue<?> value);
	public abstract boolean isNotEqual(GenericValue<?> value);
}
