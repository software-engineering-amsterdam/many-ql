package org.uva.qls.ast.style.widget;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.visitor.StyleVisitor;

public class TextboxModel extends WidgetType {

	public TextboxModel(CodePosition position) {
		super(position);
	}

	@Override
	public String toString() {
		return "textbox";
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

	@SuppressWarnings("unchecked")
	@Override
	public Boolean isValid() {
		return true;
	}

}
