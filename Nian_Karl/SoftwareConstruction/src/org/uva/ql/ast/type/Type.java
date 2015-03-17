package org.uva.ql.ast.type;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.visitor.TypeVisitor;

public abstract class Type extends BaseNode {

	public Type() {
		super(new CodePosition(0, 0));
	}

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

	public abstract <T> T accept(TypeVisitor<T> visitor);

	public boolean isUndefined() {
		return false;
	}
}
