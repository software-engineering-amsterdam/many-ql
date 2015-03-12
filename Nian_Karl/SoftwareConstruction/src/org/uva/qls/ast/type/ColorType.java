package org.uva.qls.ast.type;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.visitor.TypeVisitor;

public class ColorType extends Type {

	public ColorType() {
		super();
	}
	
	public ColorType(CodePosition pos) {
		super(pos);
	}
	
	@Override
	public boolean isColor() {
		return true;
	}	
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isEqual(Type type) {
		return type.isColor();
	}
	
	@Override
	public String toString() {
		return "Color";
	}
	
}
