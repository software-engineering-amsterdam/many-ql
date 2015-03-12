package org.uva.qls.ast.value;


public abstract class Value {

	public boolean isDefined() {
		return false;
	}

	public abstract Object value();

	public abstract String toString();

}
