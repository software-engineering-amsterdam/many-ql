package qls.ast.statement.widget.type;

import java.util.Arrays;

import ql.ast.type.QLBoolean;
import qls.ast.statement.widget.WidgetType;
import qls.ast.visitor.StatementVisitor;

public class Checkbox extends WidgetType {
	public Checkbox() {
		super(Arrays.asList(new QLBoolean()));
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Checkbox";
	}
}
