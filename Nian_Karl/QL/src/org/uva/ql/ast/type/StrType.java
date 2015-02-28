package org.uva.ql.ast.type;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.visitor.Visitor;

public class StrType extends Type {

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
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
