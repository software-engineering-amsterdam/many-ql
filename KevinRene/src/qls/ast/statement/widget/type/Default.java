package qls.ast.statement.widget.type;

import java.util.Arrays;

import ql.ast.type.QLBoolean;
import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLNumeric;
import ql.ast.type.QLString;
import qls.ast.statement.widget.WidgetType;
import qls.ast.visitor.StatementVisitor;

public class Default extends WidgetType {
	public Default() {
		super(Arrays.asList(new QLBoolean(), new QLFloat(), 
				new QLNumeric(), new QLInteger(), 
				new QLString()));
	}
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Default";
	}
}
