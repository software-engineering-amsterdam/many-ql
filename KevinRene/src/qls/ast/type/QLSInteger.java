package qls.ast.type;

import qls.ast.QLSType;
import qls.ast.visitor.Visitor;

public class QLSInteger extends QLSType {
	public QLSInteger() {	}

	@Override
	public QLSType getType() {
		return new QLSInteger();
	}
		
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}