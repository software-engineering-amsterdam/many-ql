package uva.ql.ast.value;

import java.util.List;

import uva.ql.ast.type.*;

public abstract class GenericValue<T> {

	public abstract T getValue();
	public abstract List<Type> valueHasType();
	public abstract boolean equalsTo(GenericValue<?> value);
	
}
