package uva.ql.ast.value;

import uva.ql.ast.type.*;

public abstract class GenericValue<T> {

	public abstract T getValue();
	public abstract Type valueHasType();
	public abstract boolean equalsTo(GenericValue<?> value);
	
}
