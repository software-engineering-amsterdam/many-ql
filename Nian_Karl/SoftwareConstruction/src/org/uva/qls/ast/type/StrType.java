package org.uva.qls.ast.type;

import org.uva.qls.visitor.TypeVisitor;
import org.uva.utility.CodePosition;

public class StrType extends Type {
	
	public StrType() {
		super();
	}

	public StrType(CodePosition pos) {
		super(pos);
	}

	@Override
	public boolean isStr() {
		return true;
	}

	@Override
	public boolean isEqual(Type type) {
		return type.isStr();
	}

	@Override
	public String toString() {
		return "Str";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
