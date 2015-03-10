package org.uva.qls.ast.style;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.ColorLiteral;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.visitor.StyleVisitor;

public class Color extends Style {

	private final ColorLiteral color;
	
	public Color(ColorLiteral color, CodePosition pos) {
		super(pos);
		this.color = color;
	}

	@Override
	public <T> T accept(StyleVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Literal getLiteral() {
		return color;
	}

	@Override
	public String toString() {
		return "Color<" + color.toString() + ">";
	}

}
