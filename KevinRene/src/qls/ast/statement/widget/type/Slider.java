package qls.ast.statement.widget.type;

import java.util.Arrays;

import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLNumeric;
import qls.ast.statement.widget.ValueSet;
import qls.ast.statement.widget.WidgetType;
import qls.ast.visitor.StatementVisitor;

public class Slider extends WidgetType {
	ValueSet values;
	
	public Slider(ValueSet values) {
		super(Arrays.asList(new QLFloat(), new QLInteger(), new QLNumeric()));
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
