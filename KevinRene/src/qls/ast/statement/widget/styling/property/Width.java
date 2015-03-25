package qls.ast.statement.widget.styling.property;

import java.util.Arrays;

import ql.ast.type.QLInteger;
import qls.ast.expression.Literal;
import qls.ast.statement.widget.styling.Property;
import qls.ast.visitor.StatementVisitor;

public class Width extends Property {
	public Width(Literal<?> value) {
		super(Arrays.asList(new QLInteger()), value);
	}
	
	public int getWidth() {
		return (int) getValue().getValue().getValue();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
