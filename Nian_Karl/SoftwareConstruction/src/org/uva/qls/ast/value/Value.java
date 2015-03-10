package org.uva.qls.ast.value;

import org.uva.qls.ast.type.Type;

public abstract class Value {
	
	public abstract Object getValue();
	public abstract Type getType();
	
}
