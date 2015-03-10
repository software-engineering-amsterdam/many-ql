package org.uva.ql.ast.type;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.visitor.TypeVisitable;
import org.uva.utility.CodePosition;

public abstract class Type extends BaseNode implements TypeVisitable {

	public Type(CodePosition pos) {
		super(pos);
	}

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
