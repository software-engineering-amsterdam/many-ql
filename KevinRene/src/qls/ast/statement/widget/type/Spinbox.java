package qls.ast.statement.widget.type;

import java.util.Arrays;

import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLMoney;
import ql.ast.type.QLNumeric;
import qls.ast.statement.widget.WidgetType;
import qls.ast.visitor.StatementVisitor;

public class Spinbox extends WidgetType {
	public Spinbox() {
		super(Arrays.asList(new QLFloat(), new QLInteger(), 
				new QLNumeric(), new QLMoney()));
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Spinbox";
	}
}
