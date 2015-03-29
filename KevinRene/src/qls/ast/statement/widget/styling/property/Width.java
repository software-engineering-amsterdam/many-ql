package qls.ast.statement.widget.styling.property;

import java.util.Arrays;

import ql.ast.type.QLInteger;
import qls.ast.expression.Literal;
import qls.ast.statement.widget.styling.Property;
import qls.ast.visitor.StatementVisitor;

public class Width extends Property {
	public Width(Literal<?> literal) {
		super(Arrays.asList(new QLInteger()), literal);
	}
	
	public int getWidth() {
		return (int) value().getPrimitive();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
