package qls.ast.widget;

import qls.ast.Widget;
import qls.ast.visitor.QLSStatementVisitor;

public class Spinner extends Widget {
	@Override
	public <T> T accept(QLSStatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
