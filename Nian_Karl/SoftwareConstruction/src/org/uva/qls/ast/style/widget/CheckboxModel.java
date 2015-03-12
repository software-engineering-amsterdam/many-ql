package org.uva.qls.ast.style.widget;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.visitor.StyleVisitor;

public class CheckboxModel extends WidgetType {

	public CheckboxModel(CodePosition position) {
		super(position);
	}
	
	@Override
	public String toString() {
		return "checkbox";
	}
	
	@Override
	public <T> T accept(StyleVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Literal getLiteral() {
		// TO-DO EEEH HMM..
		return null;
	}
}
