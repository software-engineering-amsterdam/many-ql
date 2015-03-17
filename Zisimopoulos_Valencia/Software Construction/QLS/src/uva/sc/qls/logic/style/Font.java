package uva.sc.qls.logic.style;

import uva.sc.qls.ast.IQLSNodeVisitor;
import uva.sc.qls.logic.fonts.FontType;

public class Font implements StyleProperty {

	FontType	value;

	public Font(FontType value) {
		this.value = value;
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public FontType getValue() {
		return value;
	}

	public String toString() {
		String result = "[Font]: " + value.toString();
		return result;
	}

}
