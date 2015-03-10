package org.uva.qls.ast.type;

import org.uva.qls.ast.QLSNode;
import org.uva.qls.visitor.TypeVisitable;

public abstract class Type implements QLSNode, TypeVisitable {
	
	public boolean isInt() {
		return false;
	}
	
	public boolean isBool() {
		return false;
	}
	
	public boolean isStr() {
		return false;
	}
	
	public boolean isUndefined() {
		return false;
	}
	
	public abstract boolean isEqual(Type type);
	
}
