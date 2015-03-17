package qls.ast.widget;

import qls.ast.Widget;
import qls.ast.visitor.StatementVisitor;

public class Spinbox extends Widget {
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Spinbox";
	}
}
