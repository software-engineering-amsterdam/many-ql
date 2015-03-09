package qls.ast.type;

import qls.ast.QLSType;
import qls.ast.visitor.Visitor;

public class QLSFloat extends QLSType {
	public QLSFloat() {	}

	@Override
	public QLSType getType() {
		return new QLSFloat();
	}
		
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}