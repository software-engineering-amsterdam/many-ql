package org.uva.qls.ast.type;

import org.uva.qls.visitor.TypeVisitor;
import org.uva.utility.CodePosition;

public class RgbType extends Type {

	public RgbType() {
		super();
	}
	
	public RgbType(CodePosition pos) {
		super(pos);
	}
	
	@Override
	public boolean isRgb() {
		return true;
	}	
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isEqual(Type type) {
		return type.isRgb();
	}
	
	@Override
	public String toString() {
		return "RGB";
	}
	
}
