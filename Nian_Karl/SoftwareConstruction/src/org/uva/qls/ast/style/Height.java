package org.uva.qls.ast.style;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.visitor.StyleVisitor;

public class Height extends StyleNumber {

	public Height(IntLiteral number, CodePosition pos) {
		super(number, pos);
	}

	@Override
	public <T> T accept(StyleVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Height<" + number.toString() + ">";
	}

}
