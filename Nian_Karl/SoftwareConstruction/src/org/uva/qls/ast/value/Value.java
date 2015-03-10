package org.uva.qls.ast.value;

public abstract class Value {
	
	public boolean isDefined(){
		return false;
	}
	
	public abstract Object getValue();
	public abstract String toString();
	
}
