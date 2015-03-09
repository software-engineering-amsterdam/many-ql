package qls.ast.type;

import qls.ast.QLSType;
import qls.ast.visitor.Visitor;

public class QLSBoolean extends QLSType {
	public QLSBoolean() {	}

	@Override
	public QLSType getType() {
		return new QLSBoolean();
	}
		
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
