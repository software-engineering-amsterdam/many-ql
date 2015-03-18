package qls.ast.statement.widget.type;

import java.util.Arrays;

import ql.ast.type.QLBoolean;
import qls.ast.statement.widget.ValueSet;
import qls.ast.statement.widget.WidgetType;
import qls.ast.visitor.StatementVisitor;

public class Dropdown extends WidgetType {
	ValueSet values;
	
	public Dropdown(ValueSet values) {
		super(Arrays.asList(new QLBoolean()));
		this.values = values;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Dropdown";
	}
}
