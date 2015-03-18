package qls.ast.statement.widget.type;

import qls.ast.statement.widget.WidgetType;
import qls.ast.visitor.StatementVisitor;

public class Slider extends WidgetType {
	ValueSet values;
	
	public Slider(ValueSet values) {
		this.values = values;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Slider";
	}
}