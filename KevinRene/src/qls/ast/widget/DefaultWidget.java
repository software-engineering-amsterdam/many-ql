package qls.ast.widget;

import qls.ast.Widget;
import qls.ast.visitor.QLSVisitor;

public class DefaultWidget extends Widget {

	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isDefault() {
		return true;
	}

	@Override
	public String toString() {
		return "DefaultWidget";
	}
}
