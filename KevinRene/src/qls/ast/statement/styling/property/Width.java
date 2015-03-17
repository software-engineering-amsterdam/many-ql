package qls.ast.statement.styling.property;

import java.util.Arrays;

import ql.ast.type.QLInteger;
import qls.ast.expression.Literal;
import qls.ast.statement.styling.StyleRule;
import qls.ast.visitor.StatementVisitor;

public class Width extends StyleRule {
	public Width(Literal<?> value) {
		super(Arrays.asList(new QLInteger()), value);
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
