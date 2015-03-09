package qls.ast.type;

import qls.ast.QLSType;
import qls.ast.visitor.Visitor;

public class QLSNumeric extends QLSType {
	public QLSNumeric() {	}

	@Override
	public QLSType getType() {
		return new QLSNumeric();
	}
		
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}