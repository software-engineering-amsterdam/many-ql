package org.uva.qls.ast.type;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.visitor.TypeVisitable;

public abstract class Type extends BaseNode implements TypeVisitable {

	public Type() {
		super(new CodePosition(0, 0));
	}
	
	public Type(CodePosition pos) {
		super(pos);
	}
	
	public boolean isIdentifier() {
		return false;
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

	public boolean isColor() {
		return false;
	}
	
	public boolean isUndefined() {
		return false;
	}
	
	public abstract boolean isEqual(Type type);
	public abstract String toString();

}
