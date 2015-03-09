package org.uva.ql.ast.type;

import org.uva.ql.ast.QLNode;
import org.uva.ql.visitor.TypeVisitable;

public abstract class Type implements QLNode, TypeVisitable {

	public boolean isInt() {
		return false;
	}

	public boolean isBool() {
		return false;
	}

	public boolean isStr() {
		return false;
	}

	public abstract boolean isEqual(Type type);

	public boolean isUndefined() {
		return false;
	}
}
