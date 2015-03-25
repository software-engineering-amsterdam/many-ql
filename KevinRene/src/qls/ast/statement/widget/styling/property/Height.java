package qls.ast.statement.widget.styling.property;

import java.util.Arrays;

import ql.ast.type.QLInteger;
import qls.ast.expression.Literal;
import qls.ast.statement.widget.styling.Property;
import qls.ast.visitor.StatementVisitor;

public class Height extends Property {
	public Height(Literal<?> value) {
		super(Arrays.asList(new QLInteger()), value);
	}
	
	public int getHeight() {
		return (int) getValue().getValue().getValue();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
