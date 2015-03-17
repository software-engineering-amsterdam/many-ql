package uva.sc.qls.logic.fonts;

import uva.sc.qls.ast.IQLSNodeVisitor;

public class Courier implements FontType {

	public java.lang.String toString() {
		return "[FontType]: Courier";
	}

	public boolean equals(FontType type) {
		if (type == null) {
			return false;
		}
		if (type instanceof Courier) {
			return true;
		}
		else {
			return false;
		}
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
