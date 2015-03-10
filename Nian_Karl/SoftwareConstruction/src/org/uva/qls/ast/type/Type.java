package org.uva.qls.ast.type;

import org.uva.ql.ast.BaseNode;
import org.uva.qls.visitor.TypeVisitable;
import org.uva.utility.CodePosition;

public abstract class Type extends BaseNode implements TypeVisitable {

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

	public boolean isColor() {
		return false;
	}
	
	public boolean isUndefined() {
		return false;
	}
	
	public abstract boolean isEqual(Type type);

}
