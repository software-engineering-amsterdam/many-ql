package qls.ast.widget;

import qls.ast.Widget;
import qls.ast.visitor.Visitor;

public class Dropdown extends Widget {
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
