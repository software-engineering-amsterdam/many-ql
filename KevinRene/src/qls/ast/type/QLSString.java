package qls.ast.type;

import qls.ast.QLSType;
import qls.ast.visitor.Visitor;

public class QLSString extends QLSType {
	public QLSString() {	}

	@Override
	public QLSType getType() {
		return new QLSString();
	}
		
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}