package org.uva.qls.ast.style;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.visitor.StyleVisitor;

public class Fontsize extends StyleNumber {

	public Fontsize(IntLiteral fontSize, CodePosition pos) {
		super(fontSize, pos);
	}

	public Fontsize(int fontSize, CodePosition pos) {
		super(fontSize, pos);
	}
	
	@Override
	public <T> T accept(StyleVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Fontsize<" + number.toString() + ">";
	}

}
