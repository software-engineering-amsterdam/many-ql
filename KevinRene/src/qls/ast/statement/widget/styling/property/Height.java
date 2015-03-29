package qls.ast.statement.widget.styling.property;

import java.util.Arrays;

import ql.ast.type.QLInteger;
import qls.ast.expression.Literal;
import qls.ast.statement.widget.styling.Property;
import qls.ast.visitor.StatementVisitor;

public class Height extends Property {
	public Height(Literal<?> literal) {
		super(Arrays.asList(new QLInteger()), literal);
	}
	
	public int getHeight() {
		return (int) value().getPrimitive();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
