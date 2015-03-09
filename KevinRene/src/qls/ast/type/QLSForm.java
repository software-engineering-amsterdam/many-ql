package qls.ast.type;

import qls.ast.QLSType;
import qls.ast.visitor.Visitor;

public class QLSForm extends QLSType {
	public QLSForm() {	}

	@Override
	public QLSType getType() {
		return new QLSForm();
	}
		
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}