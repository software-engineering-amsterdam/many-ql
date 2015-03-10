package qls.ast.widget;

import qls.ast.Widget;
import qls.ast.visitor.QLSStatementVisitor;

public class Dropdown extends Widget {
	ValueSet values;
	
	public Dropdown(ValueSet values) {
		this.values = values;
	}
	
	@Override
	public <T> T accept(QLSStatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
