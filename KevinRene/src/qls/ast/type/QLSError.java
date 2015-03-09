package qls.ast.type;

import qls.ast.QLSType;
import qls.ast.visitor.Visitor;

public class QLSError extends QLSType {
	public QLSError() {	}

	@Override
	public QLSType getType() {
		return new QLSError();
	}
		
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}