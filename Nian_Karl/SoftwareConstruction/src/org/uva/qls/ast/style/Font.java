package org.uva.qls.ast.style;

import java.util.Arrays;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.ast.literal.StrLiteral;
import org.uva.qls.visitor.StyleVisitor;

public class Font extends StyleProperty {

	// Supported Fonts, make sure to change it in the grammar too.
	private final String[] supportedFont = { "Arial" };
	private final StrLiteral font;

	public Font(StrLiteral font, CodePosition pos) {
		super(pos);
		this.font = font;
	}

	public Font(String font, CodePosition pos) {
		super(pos);
		this.font = new StrLiteral(font, pos);
	}

	@Override
	public <T> T accept(StyleVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Literal getLiteral() {
		return font;
	}

	@Override
	public String toString() {
		return "Font<" + font.toString() + ">";
	}

	@SuppressWarnings("unchecked")
	public Boolean isValid() {
		if (Arrays.asList(supportedFont).contains(font.getStringValue())) {
			return true;
		}
		return false;

	}
}
