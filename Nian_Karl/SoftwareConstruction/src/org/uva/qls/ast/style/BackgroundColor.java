package org.uva.qls.ast.style;

import java.awt.Color;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.ColorLiteral;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.visitor.StyleVisitor;

public class BackgroundColor extends StyleProperty {

	private final ColorLiteral color;

	public BackgroundColor(ColorLiteral color, CodePosition pos) {
		super(pos);
		this.color = color;
	}

	public BackgroundColor(Color color, CodePosition pos) {
		super(pos);
		this.color = new ColorLiteral(color, pos);
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
