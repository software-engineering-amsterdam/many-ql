package qls.ast.widget;

import qls.ast.Widget;
import qls.ast.visitor.QLSVisitor;

public class Spinbox extends Widget {
	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Spinbox";
	}
}
